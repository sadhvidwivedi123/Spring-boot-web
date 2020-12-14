package com.wellsfargo.batch5.pms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wellsfargo.batch5.pms.exception.PortfolioException;
import com.wellsfargo.batch5.pms.model.UserModel;
import com.wellsfargo.batch5.pms.repo.AdminRepo;
import com.wellsfargo.batch5.pms.repo.BackOfficeUserRepo;
import com.wellsfargo.batch5.pms.repo.UserRepo;
import com.wellsfargo.batch5.pms.util.PortfolioParser;

@Service
public class AdminServiceImpl implements IAdminService{
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private PasswordEncoder encoder;
	
	@Autowired
	private BackOfficeUserRepo backOfficeUserRepo;
	
	
	@Transactional
	@Override
	public UserModel addbackOfficeUser(UserModel bouser) throws PortfolioException {
		
		if(bouser!=null) {
			if(!userRepo.existsByUserName(bouser.getUserName())) {
				if(bouser.getPassword().equals(bouser.getConfirmPassword()))
				{
					bouser.setPassword(encoder.encode(bouser.getPassword()));
					backOfficeUserRepo.save(PortfolioParser.parseUserToBackOfficeUser(bouser));
				}
				
			
			}
			else
			{
			
				throw new PortfolioException("Back Office user already exists!");
			}
			
		}
		
		return bouser;
	}

}
