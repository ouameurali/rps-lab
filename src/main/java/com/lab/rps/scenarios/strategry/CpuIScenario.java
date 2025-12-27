package com.lab.rps.scenarios.strategry;

import org.springframework.stereotype.Component;

import java.util.concurrent.ThreadLocalRandom;

@Component("cpu")
public class CpuIScenario implements IScenario {
    @Override
    public String name() {
        return "CPU";
    }

    @Override
    public String execute() {
        int iters = 20_000;
        long x = 0;
        int seed = ThreadLocalRandom.current().nextInt(1, 10);
        for (int i = 0; i < iters; i++) {
            x = (x * 31) ^ (i + seed);
        }
        return "CPU:" + x;
    }
}
