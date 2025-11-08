package com.example.sba301_fa25_be_SE184884.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO for updating an existing flower
 * All fields are optional for partial updates
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FlowerUpdateRequest {
    @NotBlank(message = "Common name is required")
    @Size(min = 4, message = "Common name must be greater than 3 characters")
    private String commonName;
    @NotBlank(message = "Scientific name is required")
    @Size(max = 100)
    private String scientificName;
    @NotBlank(message = "Color is required")
    @Size(max = 20)
    private String color;
    @NotBlank(message = "Bloom season is required")
    @Size(max = 100)
    private String bloomSeason;

    @NotBlank(message = "Watering needs is required")
    @Pattern(regexp = "^(Low|Medium|High)$", message = "Watering needs must be 'Low', 'Medium', or 'High'")
    private String wateringNeeds;

    @NotBlank(message = "Medicinal uses is required")
    @Size(min = 5, max = 120, message = "Medicinal uses must be between 5 and 120 characters")
    private String medicinalUses;

    @NotNull(message = "Family ID is required")
    private Integer familyId;
}
