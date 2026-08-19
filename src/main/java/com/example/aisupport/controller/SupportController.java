package com.example.aisupport.controller;

import com.example.aisupport.dto.SupportRequest;
import com.example.aisupport.dto.SupportResponse;
import com.example.aisupport.service.AIService;
import com.example.aisupport.service.SupportAgentService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/support")
public class SupportController {

    private final SupportAgentService supportAgentService;

    public SupportController(SupportAgentService supportAgentService) {
        this.supportAgentService = supportAgentService;
    }

    @PostMapping("/ask")
    public SupportResponse ask(@RequestBody SupportRequest request) {

        return supportAgentService.process(request.getMessage());
    }
}
