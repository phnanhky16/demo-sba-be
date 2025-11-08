package com.example.sba301_fa25_be_SE184884.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.sba301_fa25_be_SE184884.entity.FlowerFamilies;

@Repository
public interface FlowerFamiliesRepository extends JpaRepository<FlowerFamilies, Integer> {
}
