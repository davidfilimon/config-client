package com.example.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class MessageController {

    @Value("${service.a.message:Valoare implicita}")
    private String message;

    @Value("${service.a.port:0000}")
    private String port;

    @GetMapping("/config")
    public String getConfig() {
        return String.format("Service A - Mesaj: %s | Port: %s",
                this.message, this.port);
    }
}