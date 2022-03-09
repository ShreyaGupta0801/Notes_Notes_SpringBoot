package com.project.notesapp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.project.notesapp.models.User;
import com.project.notesapp.repositories.UserRepo;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;

    public User addUser(User user) {
        return userRepo.save(user);
    }

    
    public List<User> findUser(String username) {
		System.out.println("login called "+username);
        username = username.replaceAll("\"", "");
        System.out.println("login called "+username);


		return userRepo.findByUsername(username);
	}
}
