package com.example.registration.controller;

import com.example.registration.model.User;
import com.example.registration.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class RegistrationController {

    @Autowired
    RegistrationService registrationService;

    @PostMapping("/registeruser")
    @CrossOrigin(origins = "http://localhost:4200")
    public User registerUser(@RequestBody User user) throws Exception{
        String tempEmailId = user.getEmailId();
        if(tempEmailId != null && !"".equals(tempEmailId)){
            User userObj = registrationService.fetchUserByEmailId(tempEmailId);
            if(userObj!=null){
                throw new Exception("user with "+tempEmailId+"is already exist");
            }
        }
        return registrationService.saveUser(user);
    }


    @PostMapping("/login")
    @CrossOrigin(origins = "http://localhost:4200")
    public User loginUser(@RequestBody User user) throws Exception{
        String tempEmailId = user.getEmailId();
        String tempPass = user.getPassword();
        User userObj= null;
        if(tempEmailId != null && tempPass !=null){
            userObj= registrationService.fetchUserByEmailIdAndPassword(tempEmailId,tempPass);
        }
        if(userObj == null){
            throw new Exception("Bad Credentials");
        }
        return userObj;
    }
}
