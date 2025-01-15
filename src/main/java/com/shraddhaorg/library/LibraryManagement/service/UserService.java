package com.shraddhaorg.library.LibraryManagement.service;

import com.shraddhaorg.library.LibraryManagement.entities.User;
import com.shraddhaorg.library.LibraryManagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired

    private UserRepository userRepository;

    //add user
    public User addUser(User user){
        return userRepository.save(user);

    }
    // get all user
    public List<User> getAllUsers(){
        return userRepository.findAll();

    }
    // Get user by ID
    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    // Delete a user by ID
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

}
