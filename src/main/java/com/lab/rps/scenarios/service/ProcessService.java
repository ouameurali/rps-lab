package com.lab.rps.scenarios.service;

import com.lab.rps.scenarios.factory.ScenarioRegistry;
import org.springframework.stereotype.Service;

@Service
public class ProcessService {

    private final ScenarioRegistry scenarioRegistry;
    public ProcessService(ScenarioRegistry scenarioRegistry) {
        this.scenarioRegistry = scenarioRegistry;
    }

    public String process(String scenario) {
        return scenarioRegistry.getRequired(scenario).execute();
    }

}
