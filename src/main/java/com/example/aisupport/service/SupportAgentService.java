package com.example.aisupport.service;

import com.example.aisupport.dto.SupportResponse;
import org.springframework.stereotype.Service;

@Service
public class SupportAgentService {

    private final AIService aiService;
    private final SupportTools supportTools;

    public SupportAgentService(
            AIService aiService,
            SupportTools supportTools) {

        this.aiService = aiService;
        this.supportTools = supportTools;
    }

    public SupportResponse process(String message) {


        SupportResponse analysis = aiService.analyze(message);


        if (analysis.getConfidence() < 0.70) {
            analysis.setEscalate(true);
            analysis.setAction("ESCALATE");
        }


        String result = executeAction(analysis.getAction());


        analysis.setResolution(result);

        return analysis;
    }

    private String executeAction(String action) {

        return switch (action) {

            case "TROUBLESHOOT_VPN" ->
                    supportTools.troubleshootVpn();

            case "RESET_PASSWORD" ->
                    supportTools.resetPassword();

            case "ESCALATE" ->
                    supportTools.escalate();

            default ->
                    supportTools.provideInformation();
        };
    }
}
