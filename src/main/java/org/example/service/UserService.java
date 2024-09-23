package org.example.service;

import org.example.dto.UserRegistrationDTO;
import org.example.entity.User;

import org.example.repository.UserRepository;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;



    @Service
    public class UserService {
        private final UserRepository userRepository;
       private final PasswordEncoder passwordEncoder;

        public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
            this.userRepository = userRepository;
            this.passwordEncoder = passwordEncoder;
        }

        public User getUserById(Long userId) {
            return userRepository.findById(userId)
                    .orElseThrow(() -> new UsernameNotFoundException("User not found with id: " + userId));
        }

        public void registerUser(UserRegistrationDTO userDto) {
            User user = new User();
            user.setName(userDto.getUsername());
            user.setEmail(userDto.getEmail());
            user.setPassword(passwordEncoder.encode(userDto.getPassword()));
            user.setPhoneNumber(userDto.getPhoneNumber());
            userRepository.save(user);
        }

        public User findByEmail(String email) {
            return userRepository.findByEmail(email)
                    .orElseThrow(() -> new UsernameNotFoundException("User not found with email: " + email));
        }

        public void updateUserProfile(UserRegistrationDTO userDto) {
            User user = userRepository.findByEmail(userDto.getEmail())
                    .orElseThrow(() -> new UsernameNotFoundException("User not found with email: " + userDto.getEmail()));
            user.setName(userDto.getUsername());
            user.setPhoneNumber(userDto.getPhoneNumber());
            userRepository.save(user);
        }



        public void deleteUser(Long userId) {
        if (!userRepository.existsById(userId)) {
            throw new UsernameNotFoundException("User not found with id "+ userId);
        }
        userRepository.deleteById(userId);
    }
}