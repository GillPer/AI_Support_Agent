package com.example.aisupport.service;

import org.springframework.stereotype.Component;

@Component
public class SupportTools {

    public String troubleshootVpn() {

        return """
                VPN Troubleshooting Steps:
                1. Check internet connectivity.
                2. Restart the VPN client.
                3. Re-authenticate.
                4. Try connecting again.
                """;
    }

    public String resetPassword() {

        return """
                Password Reset:
                1. Open the company password portal.
                2. Select 'Forgot Password'.
                3. Verify your identity.
                4. Create a new password.
                """;
    }

    public String escalate() {

        return "Your issue has been escalated to the IT support team.";
    }

    public String provideInformation() {

        return "Please provide additional information so the issue can be analyzed.";
    }
}
