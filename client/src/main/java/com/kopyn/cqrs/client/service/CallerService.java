package com.kopyn.cqrs.client.service;

import com.kopyn.cqrs.client.web.WebClient;
import org.springframework.stereotype.Service;

@Service
public class CallerService {
    private final WebClient webClient;

    public CallerService(WebClient webClient) {
        this.webClient = webClient;
    }
}
