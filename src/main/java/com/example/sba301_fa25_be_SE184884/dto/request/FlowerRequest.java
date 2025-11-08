package com.example.sba301_fa25_be_SE184884.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FlowerRequest {
    
    @NotBlank(message = "CommonName is required")
    @Size(min = 4, message = "CommonName must be greater than 3 characters")
    @Size(max = 150)
    private String commonName;
    
    @NotBlank(message = "ScientificName is required")
    @Size(max = 100)
    private String scientificName;
    
    @NotNull(message = "FamilyId is required")
    private Integer familyId;
    
    @NotBlank(message = "Color is required")
    @Size(max = 20)
    private String color;
    
    @NotBlank(message = "BloomSeason is required")
    @Size(max = 100)
    private String bloomSeason;
    
    @NotBlank(message = "WateringNeeds is required")
    @Pattern(regexp = "^(Low|Medium|High)$", message = "WateringNeeds must be 'Low', 'Medium' or 'High'")
    private String wateringNeeds;
    
    @NotBlank(message = "MedicinalUses is required")
    @Size(min = 5, max = 120, message = "MedicinalUses must be between 5 and 120 characters")
    private String medicinalUses;
}
