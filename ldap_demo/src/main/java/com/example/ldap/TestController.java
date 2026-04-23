package com.example.ldap;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class TestController {

    @GetMapping("/api/admin")
    public String admin() {
        return "admin resource";
    }

    @GetMapping("/api/dev")
    public String dev() {
        return "dev resource";
    }

    @GetMapping("/api/public")
    public Map<String, Object> publicEndpoint(Authentication authentication) {
        return Map.of(
                "user", authentication.getName(),
                "roles", authentication.getAuthorities().stream()
                        .map(GrantedAuthority::getAuthority)
                        .toList()
        );
    }
}
