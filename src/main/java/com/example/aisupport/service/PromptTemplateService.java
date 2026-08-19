package com.example.aisupport.service;

import org.springframework.stereotype.Service;

@Service
public class PromptTemplateService {

    public String createAnalysisPrompt(String userMessage) {

        return """
                ROLE:
                You are an enterprise IT support agent.

                OBJECTIVE:
                Analyze the user's IT issue.

                CATEGORIES:
                NETWORK, ACCOUNT, HARDWARE, SECURITY, SOFTWARE, OTHER

                PRIORITIES:
                LOW, MEDIUM, HIGH, CRITICAL

                RULES:
                - Security issues require escalation.
                - Critical issues require escalation.
                - Password issues should use password reset.
                - VPN issues should use VPN troubleshooting.
                - Unknown issues should be escalated.

                USER ISSUE:
                %s
                """.formatted(userMessage);
    }
}
