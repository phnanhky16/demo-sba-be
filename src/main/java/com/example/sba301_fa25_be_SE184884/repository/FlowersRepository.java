package com.example.sba301_fa25_be_SE184884.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.sba301_fa25_be_SE184884.entity.Flowers;
import java.util.List;

@Repository
public interface FlowersRepository extends JpaRepository<Flowers, Integer> {
}
