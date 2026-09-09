package com.raj.userservice.service;

import com.raj.userservice.dto.CreateUserProfileRequest;
import com.raj.userservice.entity.UserProfile;
import com.raj.userservice.repository.UserProfileRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserProfileRepository userProfileRepository;

    public UserService(UserProfileRepository userProfileRepository) {
        this.userProfileRepository = userProfileRepository;
    }

    public UserProfile createProfile(Long userId,
                                     CreateUserProfileRequest request) {

        if (userProfileRepository.findByUserId(userId).isPresent()) {
            throw new RuntimeException("User profile already exists");
        }

        UserProfile profile = new UserProfile();
        profile.setUserId(userId);
        profile.setName(request.getName());
        profile.setPhone(request.getPhone());
        profile.setCreatedAt(java.time.Instant.now());

        return userProfileRepository.save(profile);
    }

    public UserProfile getProfile(Long userId){
        UserProfile userProfile =
                userProfileRepository.findByUserId(userId)
                        .orElseThrow(() ->
                                new RuntimeException("User does not exist"));

        return userProfile;
    }
}