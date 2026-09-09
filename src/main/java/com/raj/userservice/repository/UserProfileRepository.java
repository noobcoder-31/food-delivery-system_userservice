package com.raj.userservice.repository;

import com.raj.userservice.entity.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserProfileRepository
        extends JpaRepository<UserProfile, Long> {

    Optional<UserProfile> findByUserId(Long userId);
}