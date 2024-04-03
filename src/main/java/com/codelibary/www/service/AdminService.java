package com.codelibary.www.service;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.web.multipart.MultipartFile;

import com.codelibary.www.entity.Admin;
import com.codelibary.www.entity.Feature;
import com.codelibary.www.enums.AdminSubRole;

public interface AdminService {



	List<Admin> getallAdmins();

	void deleteAdmin(Long adminId);
	
	
	Optional<Admin>  getAdminById(Long adminId);

	long countall();

	boolean isExistingAdmin(String adminName);

	void resetPassword(Long adminId, String oldPassword, String newPassword, String confirmPassword);

	Admin login(String email, String password);

	Admin assignFeaturesToAdmin(Long adminId, List<Long> featureIds);

	Admin updateFeaturesForAdmin(Long adminId, List<Long> featureIds);

	Admin removeFeaturesFromAdmin(Long adminId, List<Long> featureIds);

	Admin updateAdmin(Long adminId, String adminName, MultipartFile attachment1, String firstName, String lastName,
			Long contactNumber, String email, String state, String country, String password, String address,
			AdminSubRole adminSubrole) throws IOException;

	Admin save(String firstName, String lastName, String email, Long contactNumber, MultipartFile attactment1,
			String address, AdminSubRole adminSubrole, String state, String country, List<Long> featureIds) throws IOException;
	


	
}
