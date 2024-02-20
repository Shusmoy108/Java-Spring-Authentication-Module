package com.mywork.oauthsecurity.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mywork.oauthsecurity.document.User;
import com.mywork.oauthsecurity.dto.UserDTO;
import com.mywork.oauthsecurity.repository.UserRepository;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    UserRepository userRepository;
    
    
    @GetMapping("/")
    public ResponseEntity getMethod() {
        return ResponseEntity.ok(userRepository.findAll());
    }
    
    @GetMapping("/{id}")
    @PreAuthorize("#user.id == #id")
    public ResponseEntity user(@AuthenticationPrincipal User user, @PathVariable String id) {
        return ResponseEntity.ok(UserDTO.from(userRepository.findById(id).orElseThrow()));
    }
}