package com.codelibary.www.serviceimpl;

import java.io.IOException;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.codelibary.www.entity.Admin;
import com.codelibary.www.entity.ClientEntity;
import com.codelibary.www.entity.Feature;
import com.codelibary.www.entity.LoginTable;
import com.codelibary.www.enums.AdminSubRole;
import com.codelibary.www.repository.AdminRepository;
import com.codelibary.www.repository.ClientRepository;
import com.codelibary.www.repository.FeatureRepository;
import com.codelibary.www.repository.LoginTableRepository;
import com.codelibary.www.service.AdminService;
import com.codelibary.www.service.EmailService;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;



@Service
public class AdminServiceimpl implements AdminService{
	
	@Autowired
	private AdminRepository adminRepository;
	
	@Autowired
	private EmailService emailService;
	
	@Autowired
	private LoginTableRepository loginTableRepository;
	
	@Autowired
	private PasswordGenerator passwordGenerator;
	@Value("${spring.mail.username}")
	private String emailUsername;

	
	 @Autowired
	    private FeatureRepository featureRepository;
	
	
	 @Autowired
	 private LoginTableRepository loginRepo;
	 
	 
	 @Autowired
	 private ClientRepository clientRepo;
	 
	
	 @Transactional
	@Override
	public Admin save( String firstName, 
			String lastName,
			String email,
			Long contactNumber,
			MultipartFile attactment1, 
			String address,
			AdminSubRole adminSubrole,
			String state,
			String country,  List<Long> featureIds) throws IOException {
		Admin gg = new Admin();
		gg.setAdminName(firstName + lastName);
		gg.setContactNumber(contactNumber);
		gg.setEmail(email);
		gg.setFirstName(firstName);
		gg.setLastName(lastName);
		gg.setCountry(country);
		gg.setState(state);
//		if (gg.getDob() != null) {
//			LocalDate currentDate = LocalDate.now();
//			int age = Period.between(gg.getDob(), currentDate).getYears();
//			gg.setAge(age);
//		}
		gg.setRole("Admin");
		gg.setAttcatment1(attactment1 != null ? attactment1.getBytes() : null);
		gg.setAdminSubrole((AdminSubRole)  adminSubrole);
		gg.setAddress(address);
		String generatedPassword = passwordGenerator.generatePassword(8);
		gg.setPassword(generatedPassword);
		LocalDate date = LocalDate.now();
		emailService.sendEmail(email, emailUsername, null, "Registration Successful\n",
				"Hi  " + gg.getAdminName() + " has been successfully register." + "\n" + "Please login through UserName "
						+ gg.getAdminName()+ "\n " + "Your Password is " + gg.getPassword());
		
		System.err.println(java.sql.Date.valueOf(date));
		gg.setCreatedBy(java.sql.Date.valueOf(date));
		System.err.println(featureIds);
		List<Feature> features = featureRepository.findAllById(featureIds);
		System.err.println(features);
		gg.getFeatures().addAll(features);

		Admin adminsave = adminRepository.save(gg);
		 LoginTable logins=new LoginTable();

		 logins.setAdmin(adminsave);
		 logins.setUserName(adminsave.getAdminName());
		 logins.setPassword(adminsave.getPassword());
		 logins.setRole(adminsave.getRole());
		 loginTableRepository.save(logins);
		 
		return adminsave;
	}

	@Override
	public List<Admin> getallAdmins() {

		return adminRepository.findAll();
	}


//	@Override
//	public void deleteAdmin(Long adminId) {
//		adminRepository.deleteById(adminId);
//		
//	}
	@Override
	@Transactional
    public void deleteAdmin(Long adminId) {
        // Find the admin by ID
		System.err.println("yoyo");
		
		
        Admin admin = adminRepository.findById(adminId)
                .orElseThrow(() -> new EntityNotFoundException("Admin with ID " + adminId + " not found"));
        

     List<ClientEntity> list = admin.getClientEntityList();
    
     // Use the IDs from the list directly
     	for(int i = 0 ; i < list.size(); i++) {
     		
     		loginRepo.deleteByUser(list.get(i));
     		
     	}
     
        
    	LoginTable login = loginRepo.findByAdmin(admin);
        

    	
    	if(login != null) {
    		System.err.println("executed123");
    		loginRepo.deleteById(login.getLoginId());
    	}
    	
       
        System.err.println(admin);
        // Delete associated records in LoginTable
        if (admin.getAdminId() != null) {
        	
        	System.err.println("exceuted");
            loginTableRepository.deleteByAdmin(admin);
            
        } else {
        	
        }

        // Delete the admin
        adminRepository.deleteById(adminId);
    }

	@Override
	public long countall() {
		
		return adminRepository.count();
	}

	@Override
	public boolean isExistingAdmin(String adminName) {
	
		return false;
	}

	@Override
	public void resetPassword(Long adminId, String oldPassword, String newPassword, String confirmPassword) {
	    Optional<Admin> adminOptional = adminRepository.findById(adminId);

	    if (adminOptional.isPresent()) {
	        Admin admin = adminOptional.get();

	        if (!admin.getPassword().equals(oldPassword)) {
	            throw new IllegalArgumentException("Old password is incorrect.");
	        }

	        if (!newPassword.equals(confirmPassword)) {
	            throw new IllegalArgumentException("New password and confirm password do not match.");
	        }

	        admin.setPassword(newPassword);

	        adminRepository.save(admin);
	    } else {
	        throw new EntityNotFoundException("Admin not found with ID: " + adminId);
	    }
	}


	@Override
	public Admin login(String email, String password) {

		return adminRepository.findByEmailAndPassword(email, password);
	}

	@Override
	public Optional<Admin> getAdminById(Long adminId) {

		return adminRepository.findById(adminId);
	}

	@Override
	public Admin updateAdmin(Long adminId, String adminName, MultipartFile attachment1, String firstName,
	        String lastName, Long contactNumber, String email, String state, String country, String password,
	        String address, AdminSubRole adminSubrole) throws IOException {
	    System.out.println("Executed");

	    // Find the existing admin by ID
	    Optional<Admin> existingAdminOptional = adminRepository.findById(adminId);

	    if (existingAdminOptional.isPresent()) {
	        Admin existingAdmin = existingAdminOptional.get();

	        // Update fields with non-null values
	        if (adminName != null) {
	            existingAdmin.setAdminName(adminName);
	        }

	        if (attachment1 != null && !attachment1.isEmpty()) {
	            // Handle the attachment update logic here
	            byte[] attachmentBytes = attachment1.getBytes();
	            existingAdmin.setAttcatment1(attachmentBytes);
	        }

	        if (firstName != null) {
	            existingAdmin.setFirstName(firstName);
	        }

	        if (lastName != null) {
	            existingAdmin.setLastName(lastName);
	        }

	        if (contactNumber != null) {
	            existingAdmin.setContactNumber(contactNumber);
	        }

	        if (email != null) {
	            existingAdmin.setEmail(email);
	        }

	        if (state != null) {
	            existingAdmin.setState(state);
	        }

	        if (country != null) {
	            existingAdmin.setCountry(country);
	        }

	        if (password != null) {
	            existingAdmin.setPassword(password);
	        }

	        if (address != null) {
	            existingAdmin.setAddress(address);
	        }

	        if (adminSubrole != null) {
	            existingAdmin.setAdminSubrole(adminSubrole);
	        }

	        // Save the updated admin
	        return adminRepository.save(existingAdmin);
	    } else {
	        // Admin with the given ID not found
	        throw new NoSuchElementException("Admin with ID " + adminId + " not found");
	    }
	}

	@Override
	   public Admin assignFeaturesToAdmin(Long adminId, List<Long> featureIds) {
	        Admin admin = adminRepository.findById(adminId).orElseThrow(() -> new RuntimeException("Admin not found"));

	        // Fetch features from the database
	        List<Feature> features = featureRepository.findAllById(featureIds);

	        // Assign features to admin
	        admin.getFeatures().addAll(features);

	        // Save the updated admin entity
	        return adminRepository.save(admin);
	    }
	
	@Override
	public Admin updateFeaturesForAdmin(Long adminId, List<Long> featureIds) {
	    Admin admin = adminRepository.findById(adminId).orElseThrow(() -> new RuntimeException("Admin not found"));

	    // Fetch features from the database
	    List<Feature> features = featureRepository.findAllById(featureIds);

	    // Update features for admin
	    admin.setFeatures(new HashSet<>(features));

	    // Save the updated admin entity
	    return adminRepository.save(admin);
	}

	@Override
	public Admin removeFeaturesFromAdmin(Long adminId, List<Long> featureIds) {
	    Admin admin = adminRepository.findById(adminId).orElseThrow(() -> new RuntimeException("Admin not found"));

	    // Fetch features from the database
	    List<Feature> featuresToRemove = featureRepository.findAllById(featureIds);

	    // Remove features from admin
	    admin.getFeatures().removeAll(featuresToRemove);

	    // Save the updated admin entity
	    return adminRepository.save(admin);
	}

}
