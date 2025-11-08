package com.example.sba301_fa25_be_SE184884.controller;

import com.example.sba301_fa25_be_SE184884.dto.request.LoginRequest;
import com.example.sba301_fa25_be_SE184884.dto.response.LoginResponse;
import com.example.sba301_fa25_be_SE184884.service.SystemAccountsService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @Autowired
    private SystemAccountsService systemAccountsService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@Valid @RequestBody LoginRequest request) {
        LoginResponse response = systemAccountsService.authenticate(request);
        return ResponseEntity.ok(response);
    }
}
