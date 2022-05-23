package com.example.tp3.repository;

import com.example.tp3.model.*;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AdminRepository extends JpaRepository<Admin, Long> {

    List<Admin> findAll();

}
