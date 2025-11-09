package com.example.sba301_fa25_be_SE184884.service;

import com.example.sba301_fa25_be_SE184884.dto.response.FlowerFamilyResponse;
import com.example.sba301_fa25_be_SE184884.entity.FlowerFamilies;
import com.example.sba301_fa25_be_SE184884.repository.FlowerFamiliesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FlowerFamiliesService {

    @Autowired
    private FlowerFamiliesRepository flowerFamiliesRepository;

    public List<FlowerFamilyResponse> getAllFlowerFamilies() {
        List<FlowerFamilies> families = flowerFamiliesRepository.findAll();
        return families.stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    private FlowerFamilyResponse mapToResponse(FlowerFamilies family) {
        FlowerFamilyResponse response = new FlowerFamilyResponse();
        response.setFamilyId(family.getFamilyId());
        response.setFamilyName(family.getFamilyName());
        response.setDescription(family.getDescription());
        response.setNumberOfSpecies(family.getNumberOfSpecies());
        return response;
    }
}
