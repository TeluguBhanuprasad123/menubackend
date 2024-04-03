package com.codelibary.www.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codelibary.www.entity.Admin;
import com.codelibary.www.entity.ClientEntity;
import com.codelibary.www.entity.LoginTable;

public interface LoginTableRepository extends JpaRepository<LoginTable, Long>{

	LoginTable findByAdmin(Admin admin);
	
	LoginTable deleteByUser(ClientEntity clientEntity);
	
	LoginTable findByUserNameAndPassword(String userName, String password);

    LoginTable findByUser(ClientEntity user);
    
    void deleteByAdmin(Admin admin);
    
 // Add this method to LoginTableRepository
    LoginTable findByResetToken(String resetToken);

    	LoginTable findByUserName(String userName);
    
    
}
