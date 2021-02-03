package com.example.demo.controllers;

import com.example.demo.repositories.RoleRepository;
import com.example.demo.repositories.UserRepository;
import com.example.demo.security.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    JwtUtils jwtUtils;

//    @PostMapping("/auth/signin")
//    public ResponseEntity authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
////        Authentication authentication = authenticationManager.authenticate(
////                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
////
////        String jwt = jwtUtils.generateJwtToken(authentication);
////
////        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
////        List<String> roles = userDetails.getAuthorities().stream()
////                .map(item -> item.getAuthority())
////                .collect(Collectors.toList());
//
//        return ResponseEntity.ok();
//    }
}
