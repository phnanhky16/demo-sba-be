package com.example.sba301_fa25_be_SE184884.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginResponse {
    private String token;
    private Integer accountId;
    private String email;
    private String username;
    private Integer role;
}
