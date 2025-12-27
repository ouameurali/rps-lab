package com.lab.rps.scenarios.strategry;

import org.springframework.stereotype.Component;

@Component( "alloc")
public class AllocIScenario implements IScenario {
    @Override
    public String name() {
        return "alloc";
    }
    @Override
    public String execute() {
       /* byte[] b = new byte[8 * 1024];
        b[0] = 1;*/
        return "ALLOC:";
    }
}
