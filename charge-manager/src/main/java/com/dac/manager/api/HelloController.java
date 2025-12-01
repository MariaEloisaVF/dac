package com.dac.manager.api;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@RestController
public class HelloController {
    private final RestTemplate rest = new RestTemplate();

    @Value("${proxy.url:http://localhost:8081}")
    private String proxyUrl;

    @GetMapping("/manager/hello")
    public Object hello() {
        String proxyResp = "{}";
        try {
            proxyResp = rest.getForObject(proxyUrl + "/proxy/hello", String.class);
        } catch (Exception e) {
            proxyResp = "{\"error\":\"proxy unavailable\"}";
        }
        return java.util.Map.of("hello from manager", "ok", "proxy", proxyResp);
    }
}