package com.example.sba301_fa25_be_SE184884.service;

import com.example.sba301_fa25_be_SE184884.dto.request.FlowerRequest;
import com.example.sba301_fa25_be_SE184884.dto.response.FlowerResponse;
import com.example.sba301_fa25_be_SE184884.entity.FlowerFamilies;
import com.example.sba301_fa25_be_SE184884.entity.Flowers;
import com.example.sba301_fa25_be_SE184884.repository.FlowerFamiliesRepository;
import com.example.sba301_fa25_be_SE184884.repository.FlowersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FlowersService {

    @Autowired
    private FlowersRepository flowersRepository;

    @Autowired
    private FlowerFamiliesRepository flowerFamiliesRepository;

    public List<FlowerResponse> getAllFlowers() {
        return flowersRepository.findAll().stream()
                .map(this::convertToResponse)
                .collect(Collectors.toList());
    }

    public FlowerResponse createFlower(FlowerRequest request) {
        FlowerFamilies family = flowerFamiliesRepository.findById(request.getFamilyId())
                .orElseThrow(() -> new RuntimeException("Family not found with id: " + request.getFamilyId()));

        Flowers flower = new Flowers();
        flower.setCommonName(request.getCommonName());
        flower.setScientificName(request.getScientificName());
        flower.setFamily(family);
        flower.setColor(request.getColor());
        flower.setBloomSeason(request.getBloomSeason());
        flower.setWateringNeeds(request.getWateringNeeds());
        flower.setMedicinalUses(request.getMedicinalUses());

        Flowers saved = flowersRepository.save(flower);
        return convertToResponse(saved);
    }

    public FlowerResponse updateFlower(Integer id, FlowerRequest request) {
        Flowers flower = flowersRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Flower not found with id: " + id));

        FlowerFamilies family = flowerFamiliesRepository.findById(request.getFamilyId())
                .orElseThrow(() -> new RuntimeException("Family not found with id: " + request.getFamilyId()));

        flower.setCommonName(request.getCommonName());
        flower.setScientificName(request.getScientificName());
        flower.setFamily(family);
        flower.setColor(request.getColor());
        flower.setBloomSeason(request.getBloomSeason());
        flower.setWateringNeeds(request.getWateringNeeds());
        flower.setMedicinalUses(request.getMedicinalUses());

        Flowers updated = flowersRepository.save(flower);
        return convertToResponse(updated);
    }

    public void deleteFlower(Integer id) {
        if (!flowersRepository.existsById(id)) {
            throw new RuntimeException("Flower not found with id: " + id);
        }
        flowersRepository.deleteById(id);
    }

    public List<FlowerResponse> searchFlowers(String commonName, String wateringNeeds) {
        List<Flowers> flowers;
        
        if (commonName != null && wateringNeeds != null) {
            flowers = flowersRepository.findByCommonNameContainingIgnoreCaseAndWateringNeeds(commonName, wateringNeeds);
        } else if (commonName != null) {
            flowers = flowersRepository.findByCommonNameContainingIgnoreCase(commonName);
        } else if (wateringNeeds != null) {
            flowers = flowersRepository.findByWateringNeeds(wateringNeeds);
        } else {
            flowers = flowersRepository.findAll();
        }
        
        return flowers.stream()
                .map(this::convertToResponse)
                .collect(Collectors.toList());
    }

    private FlowerResponse convertToResponse(Flowers flower) {
        FlowerResponse response = new FlowerResponse();
        response.setFlowerId(flower.getFlowerId());
        response.setCommonName(flower.getCommonName());
        response.setScientificName(flower.getScientificName());
        response.setColor(flower.getColor());
        response.setBloomSeason(flower.getBloomSeason());
        response.setWateringNeeds(flower.getWateringNeeds());
        response.setMedicinalUses(flower.getMedicinalUses());
        response.setFamilyId(flower.getFamily().getFamilyId());
        response.setFamilyName(flower.getFamily().getFamilyName());
        return response;
    }
}
