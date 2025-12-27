package com.lab.rps.contoller;

import com.lab.rps.scenarios.service.ProcessService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@Slf4j
public class ProcessController {
    private final ProcessService processService;
    public ProcessController(ProcessService processService) {
        this.processService = processService;
    }
    @GetMapping("/process")
    public String process(@RequestParam String scenario){
       log.info("Thread: {}", Thread.currentThread());
        return processService.process(scenario);
    }

}
