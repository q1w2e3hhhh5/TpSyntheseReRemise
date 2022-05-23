package com.example.tp3.service;

import com.example.tp3.model.*;
import com.example.tp3.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    public Admin createAdmin(String email, String password, String fullName) {
        return adminRepository.save(new Admin(email, password, fullName));
    }
}
