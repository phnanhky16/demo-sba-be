package com.example.sba301_fa25_be_SE184884.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Flowers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int flowerId;

    @NotBlank
    @Size(max = 150)
    String commonName;

    @NotBlank
    @Size(max = 100)
    String scientificName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "familyId")
    @JsonIgnoreProperties("flowers")
    @NotNull
    FlowerFamilies family;
    @NotBlank
    @Size(max = 20)
    String color;
    @NotBlank
    @Size(max = 100)
    String bloomSeason;
    @NotBlank
    @Size(max = 50)
    String wateringNeeds;
    @NotBlank
    @Size(max = 120)
    String medicinalUses;
}
