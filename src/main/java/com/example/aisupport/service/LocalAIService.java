package com.example.aisupport.service;

import com.example.aisupport.dto.SupportResponse;
import org.springframework.stereotype.Service;

@Service
public class LocalAIService implements AIService {

    @Override
    public SupportResponse analyze(String message) {

        String input = message.toLowerCase();

        SupportResponse response = new SupportResponse();

        if (input.contains("hack")
                || input.contains("hacked")
                || input.contains("unauthorized")
                || input.contains("suspicious login")) {

            response.setCategory("SECURITY");
            response.setPriority("CRITICAL");
            response.setAction("ESCALATE");
            response.setResolution(
                    "Security issue detected. Escalate immediately to the security team."
            );
            response.setEscalate(true);
            response.setConfidence(0.98);

        } else if (input.contains("vpn")
                || input.contains("network")
                || input.contains("internet")
                || input.contains("wifi")) {

            response.setCategory("NETWORK");
            response.setPriority("MEDIUM");
            response.setAction("TROUBLESHOOT_VPN");
            response.setResolution(
                    "Check your internet connection, restart the VPN client and retry."
            );
            response.setEscalate(false);
            response.setConfidence(0.92);

        } else if (input.contains("password")
                || input.contains("forgot password")
                || input.contains("login")) {

            response.setCategory("ACCOUNT");
            response.setPriority("LOW");
            response.setAction("RESET_PASSWORD");
            response.setResolution(
                    "Use the company password reset portal to reset your password."
            );
            response.setEscalate(false);
            response.setConfidence(0.94);

        } else if (input.contains("laptop")
                || input.contains("computer")
                || input.contains("keyboard")
                || input.contains("mouse")) {

            response.setCategory("HARDWARE");
            response.setPriority("MEDIUM");
            response.setAction("PROVIDE_INFORMATION");
            response.setResolution(
                    "Please restart the device and check the hardware connections."
            );
            response.setEscalate(false);
            response.setConfidence(0.85);

        } else {

            response.setCategory("OTHER");
            response.setPriority("MEDIUM");
            response.setAction("ESCALATE");
            response.setResolution(
                    "I could not confidently identify the issue. A support engineer should review it."
            );
            response.setEscalate(true);
            response.setConfidence(0.40);
        }

        return response;
    }
}
