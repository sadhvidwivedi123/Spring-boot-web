package com.wellsfargo.batch5.pms.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.wellsfargo.batch5.pms.entity.AdminEntity;
import com.wellsfargo.batch5.pms.repo.AdminRepo;

@Component
public class OnApplicationStartCreateAdmin {
	
	@Autowired
	private AdminRepo adminRepo;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@EventListener
	public void checkAndCreateAdmin(ApplicationStartedEvent event) {
		
		if(!adminRepo.existsByUserName("superadmin")) {
			
			adminRepo.save(new AdminEntity(null, "superadmin", passwordEncoder.encode("superadmin"), "admin", "admin@pms.com", "2345689999", "Admin"));
			
		}
		
	}
	
	

}
