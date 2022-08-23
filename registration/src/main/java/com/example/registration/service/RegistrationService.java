package com.example.registration.service;

import com.example.registration.model.User;
import com.example.registration.repo.RegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {

    @Autowired
    RegistrationRepository registrationRepository;

    public User saveUser(User user){
        return registrationRepository.save(user);
    }

    public User fetchUserByEmailId(String email){
        return registrationRepository.findByEmailId(email);
    }

    public User fetchUserByEmailIdAndPassword(String emailId, String password){
        return registrationRepository.findByEmailIdAndPassword(emailId,password);
    }
}
