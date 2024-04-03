package com.codelibary.www.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codelibary.www.entity.MasterAdmin;

public interface MasterAdminRepository extends JpaRepository<MasterAdmin, Long> {

	MasterAdmin findByEmailAndPassword(String email, String password);

}
