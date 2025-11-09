package com.example.sba301_fa25_be_SE184884.controller;

import com.example.sba301_fa25_be_SE184884.dto.response.FlowerFamilyResponse;
import com.example.sba301_fa25_be_SE184884.service.FlowerFamiliesService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/flower-families")
@Tag(name = "Flower Families", description = "Flower family management APIs")
@SecurityRequirement(name = "bearerAuth")
public class FlowerFamiliesController {

    @Autowired
    private FlowerFamiliesService flowerFamiliesService;

    @GetMapping
    @PreAuthorize("hasAnyRole('1', '2', '3')")
    @Operation(summary = "Get all flower families", description = "List all flower families. Roles: Administrator(1), Moderator(2), Member(3)")
    public ResponseEntity<List<FlowerFamilyResponse>> getAllFlowerFamilies() {
        List<FlowerFamilyResponse> families = flowerFamiliesService.getAllFlowerFamilies();
        return ResponseEntity.ok(families);
    }
}
