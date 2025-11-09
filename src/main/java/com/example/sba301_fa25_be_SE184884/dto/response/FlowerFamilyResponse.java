package com.example.sba301_fa25_be_SE184884.dto.response;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class FlowerFamilyResponse {
    int familyId;
    String familyName;
    String description;
    int numberOfSpecies;
}
