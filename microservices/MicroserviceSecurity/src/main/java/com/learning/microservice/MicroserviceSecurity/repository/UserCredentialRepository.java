package com.learning.microservice.MicroserviceSecurity.repository;

import com.learning.microservice.MicroserviceSecurity.entity.UserCredential;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserCredentialRepository extends JpaRepository<UserCredential,Integer> {
    Optional<UserCredential> findByName(String username);
}
