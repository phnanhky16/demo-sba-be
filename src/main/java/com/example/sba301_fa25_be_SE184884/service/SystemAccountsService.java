package com.example.sba301_fa25_be_SE184884.service;

import com.example.sba301_fa25_be_SE184884.dto.request.LoginRequest;
import com.example.sba301_fa25_be_SE184884.dto.response.LoginResponse;
import com.example.sba301_fa25_be_SE184884.entity.SystemAccounts;
import com.example.sba301_fa25_be_SE184884.repository.SystemAccountsRepository;
import com.example.sba301_fa25_be_SE184884.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class SystemAccountsService implements UserDetailsService {

    @Autowired
    private SystemAccountsRepository systemAccountsRepository;

    @Autowired
    private JwtUtil jwtUtil;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        SystemAccounts account = systemAccountsRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with email: " + email));
        return new User(
                account.getEmail(),
                account.getPassword(),
                account.isActive(),
                true,
                true,
                true,
                Collections.singletonList(new SimpleGrantedAuthority("ROLE_" + account.getRole()))
        );
    }

    public LoginResponse authenticate(LoginRequest request) {
        SystemAccounts account = systemAccountsRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("Invalid email or password"));

        if (!account.isActive()) {
            throw new RuntimeException("Account is not active");
        }

        if (!request.getPassword().equals(account.getPassword())) {
            throw new RuntimeException("Invalid email or password");
        }

        String token = jwtUtil.generateToken(account.getEmail(), account.getAccountId(), account.getRole());

        LoginResponse response = new LoginResponse();
        response.setToken(token);
        response.setAccountId(account.getAccountId());
        response.setEmail(account.getEmail());
        response.setUsername(account.getUsername());
        response.setRole(account.getRole());
        return response;
    }
}
