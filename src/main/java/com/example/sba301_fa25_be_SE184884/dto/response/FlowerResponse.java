package com.example.sba301_fa25_be_SE184884.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO for flower response
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FlowerResponse {
    
    private Integer flowerId;
    
    private String commonName;
    
    private String scientificName;
    
    private String color;
    
    private String bloomSeason;
    
    private String wateringNeeds;
    
    private String medicinalUses;
    
    private Integer familyId;
    
    private String familyName;
}
