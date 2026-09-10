package com.raj.userservice.controller;

import com.raj.userservice.dto.CreateUserProfileRequest;
import com.raj.userservice.entity.UserProfile;
import com.raj.userservice.repository.UserProfileRepository;
import com.raj.userservice.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;
    private final UserProfileRepository userProfileRepository;

    public UserController(UserService userService,UserProfileRepository userProfileRepository) {
        this.userService = userService;
        this.userProfileRepository = userProfileRepository;
    }

    @PostMapping("/me")
    @ResponseStatus(HttpStatus.CREATED)
    public UserProfile createProfile(
            @PathVariable Long userId,
            @Valid @RequestBody CreateUserProfileRequest request) {

        return userService.createProfile(request);
    }

    @GetMapping("/me")
    public ResponseEntity<UserProfile> getProfile() {

        UserProfile userProfile = userService.getProfile();

        return ResponseEntity.ok(userProfile);
    }
}