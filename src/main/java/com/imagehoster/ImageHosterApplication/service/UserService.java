package com.imagehoster.ImageHosterApplication.service;

import com.imagehoster.ImageHosterApplication.model.User;
import com.imagehoster.ImageHosterApplication.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User login(User user){
        User exsitingUser = userRepository.checkCredentials(user.getUsername(),user.getPassword());
        if(exsitingUser == null){
            return null;
        }
        else{
            return exsitingUser;
        }
    }

    public void signupUser(User newUser){
        userRepository.signupUser(newUser);
    }


}
