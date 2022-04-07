package com.example.restapi.accounts;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Accounts, Integer> {
    Optional<Accounts> findByEmail(String email);
}
