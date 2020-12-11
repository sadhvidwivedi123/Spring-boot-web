package com.wellsfargo.batch5.pms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.wellsfargo.batch5.pms.exception.PortfolioException;
import com.wellsfargo.batch5.pms.model.InvestorRegisterModel;
import com.wellsfargo.batch5.pms.model.UserModel;
import com.wellsfargo.batch5.pms.repo.InvestorRepo;
import com.wellsfargo.batch5.pms.repo.UserRepo;
import com.wellsfargo.batch5.pms.util.PortfolioParser;
@Service
public class HomeServiceImpl implements IHomeService{
	
	@Autowired
	private PasswordEncoder encoder;
	
	@Autowired
	private InvestorRepo investorRepo; 
	
	@Autowired
	private UserRepo userRepo; 

	@Override
	public InvestorRegisterModel register(InvestorRegisterModel user) throws PortfolioException {
		
		if(user!=null)
		{
			if(!userRepo.existsByUserName(user.getUserName())) 
			{
				if(user.getPassword().equals(user.getConfirmPassword()))
				{
					if(!investorRepo.existsByPanId(user.getPanId()))
					{
					user.setPassword(encoder.encode(user.getPassword()));
					investorRepo.save(PortfolioParser.parse(user));
					}
					else
					{
						throw new PortfolioException("User PAN already registered. Please login");
					}
				}
				else
				{
					throw new PortfolioException("Password and Confirm password do not match");
				}
			}
			else
			{
				throw new PortfolioException("Username already Exists");
			}
		}
		return user;
	}


	@Override
	public void login(UserModel user) throws PortfolioException {
		// TODO Auto-generated method stub
		
	}

}
