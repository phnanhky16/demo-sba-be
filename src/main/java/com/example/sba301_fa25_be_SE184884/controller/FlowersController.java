package com.example.sba301_fa25_be_SE184884.controller;

import com.example.sba301_fa25_be_SE184884.dto.request.FlowerRequest;
import com.example.sba301_fa25_be_SE184884.dto.response.FlowerResponse;
import com.example.sba301_fa25_be_SE184884.service.FlowersService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/flowers")
@Tag(name = "Flowers", description = "Flower management APIs")
@SecurityRequirement(name = "bearerAuth")
public class FlowersController {

    @Autowired
    private FlowersService flowersService;

    @GetMapping
    @PreAuthorize("hasAnyRole('1', '2', '3')")
    @Operation(summary = "Get all flowers", description = "List all flowers with FamilyName from FlowerFamilies. Roles: Administrator(1), Moderator(2), Member(3)")
    public ResponseEntity<List<FlowerResponse>> getAllFlowers() {
        List<FlowerResponse> flowers = flowersService.getAllFlowers();
        return ResponseEntity.ok(flowers);
    }

    @PostMapping
    @PreAuthorize("hasAnyRole('1', '2')")
    @Operation(summary = "Create a new flower", description = "Create a new flower. Roles: Administrator(1), Moderator(2)")
    public ResponseEntity<FlowerResponse> createFlower(@Valid @RequestBody FlowerRequest request) {
        FlowerResponse created = flowersService.createFlower(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAnyRole('1', '2')")
    @Operation(summary = "Update a flower", description = "Update an existing flower. Roles: Administrator(1), Moderator(2)")
    public ResponseEntity<FlowerResponse> updateFlower(
            @PathVariable Integer id,
            @Valid @RequestBody FlowerRequest request) {
        FlowerResponse updated = flowersService.updateFlower(id, request);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('1')")
    @Operation(summary = "Delete a flower", description = "Delete an existing flower. Roles: Administrator(1) only")
    public ResponseEntity<Void> deleteFlower(@PathVariable Integer id) {
        flowersService.deleteFlower(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/search")
    @PreAuthorize("hasAnyRole('1', '2', '3')")
    @Operation(summary = "Search flowers", description = "Search flowers by CommonName AND/OR WateringNeeds. Roles: Administrator(1), Moderator(2), Member(3)")
    public ResponseEntity<List<FlowerResponse>> searchFlowers(
            @RequestParam(required = false) String commonName,
            @RequestParam(required = false) String wateringNeeds) {
        List<FlowerResponse> flowers = flowersService.searchFlowers(commonName, wateringNeeds);
        return ResponseEntity.ok(flowers);
    }
}
