package com.lab.rps.scenarios.strategry;

import org.springframework.stereotype.Component;

@Component("ping")
public class PingIScenario implements IScenario {
    @Override
    public String name() {
        return "ping";
    }

    @Override
    public String execute() {
        return "OK";
    }
}
