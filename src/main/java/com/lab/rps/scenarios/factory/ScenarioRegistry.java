package com.lab.rps.scenarios.factory;

import com.lab.rps.scenarios.strategry.IScenario;
import org.springframework.stereotype.Component;

import java.util.Map;

/*Pattern Factory */
@Component
public class ScenarioRegistry {

    private final Map<String, IScenario> scenarios;  // le choix du scenario est dyamique , il vient de l'appel API

    public ScenarioRegistry(Map<String, IScenario> scenario) {
        this.scenarios = Map.copyOf(scenario); //copyOf : map immuable après construction, et elle est thread safe
    }

    public IScenario getRequired(String name) {
        IScenario s = scenarios.get(name);
        if (s == null) {
            throw new IllegalArgumentException("Unknown scenario: " + name);
        }
        return s;
    }

}
