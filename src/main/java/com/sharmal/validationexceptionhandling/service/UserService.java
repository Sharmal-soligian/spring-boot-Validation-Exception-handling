package com.sharmal.validationexceptionhandling.service;

import com.sharmal.validationexceptionhandling.dto.UserRequest;
import com.sharmal.validationexceptionhandling.exception.UserNotFoundException;
import com.sharmal.validationexceptionhandling.model.User;
import com.sharmal.validationexceptionhandling.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;

    public User saveUser(UserRequest userRequest) {
        User user = User.build(
                0,
                userRequest.getName(),
                userRequest.getEmail(),
                userRequest.getMobile(),
                userRequest.getGender(),
                userRequest.getAge(),
                userRequest.getNationality());
        return userRepo.save(user);
    }

    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    public User getUser(int id) throws UserNotFoundException {
        User user =  userRepo.findByUserId(id);
        if (user != null) {
            return user;
        } else {
            throw new UserNotFoundException("User not found for this Id");
        }
    }
}
