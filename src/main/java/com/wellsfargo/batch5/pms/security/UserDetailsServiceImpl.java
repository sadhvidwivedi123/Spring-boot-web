package com.wellsfargo.batch5.pms.security;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.wellsfargo.batch5.pms.entity.UserEntity;
import com.wellsfargo.batch5.pms.exception.PortfolioException;
import com.wellsfargo.batch5.pms.model.UserModel;
import com.wellsfargo.batch5.pms.repo.UserRepo;
import com.wellsfargo.batch5.pms.util.PortfolioParser;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{

	@Autowired
	private UserRepo userRepo;
	
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		UserDetails userDetails=null;
		if(!userRepo.existsByUserName(username))
		{
			throw new UsernameNotFoundException("Invalid User Credentials!");
		}
		
		UserEntity user=userRepo.findByUserName(username);
		userDetails=new User(user.getUserName(),user.getPassword(),Collections.singletonList(new SimpleGrantedAuthority(user.getRole())));
		return userDetails;
	}

}
