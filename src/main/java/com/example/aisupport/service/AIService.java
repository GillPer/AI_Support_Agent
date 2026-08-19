package com.example.aisupport.service;

import com.example.aisupport.dto.SupportResponse;

public interface AIService {
    SupportResponse analyze(String message);
}
