package com.codelibary.www.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codelibary.www.entity.Admin;

public interface AdminRepository extends JpaRepository<Admin, Long> {

	Admin findByEmailAndPassword(String email, String password);

}
