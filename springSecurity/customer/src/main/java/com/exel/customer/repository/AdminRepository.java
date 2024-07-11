package com.exel.customer.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exel.customer.entity.Admin;

public interface AdminRepository extends JpaRepository<Admin, Integer> {
Optional<Admin> findByEmail(String email);
}
