package com.dac.proxy.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProxyController {
    @GetMapping("/proxy/hello")
    public Object hello() {
        return java.util.Map.of("message", "hello from proxy");
    }
}
