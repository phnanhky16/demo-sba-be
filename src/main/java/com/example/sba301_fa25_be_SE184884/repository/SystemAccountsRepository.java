package com.example.sba301_fa25_be_SE184884.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.sba301_fa25_be_SE184884.entity.SystemAccounts;

@Repository
public interface SystemAccountsRepository extends JpaRepository<SystemAccounts, Integer> {
    Optional<SystemAccounts> findByEmail(String email);
    Optional<SystemAccounts> findByEmailAndPasswordAndIsActive(String email, String password, boolean isActive);
}
