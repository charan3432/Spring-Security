package com.charan.spring_security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.charan.spring_security.dao.UserRepo;
import com.charan.spring_security.model.User;
import com.charan.spring_security.model.UserPrincipal;

@Service
public class MyUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserRepo repo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = repo.findByUsername(username);
		
		if(user==null) {
			System.out.println("Usern not Found 404!..");
			throw new UsernameNotFoundException("User NotFound 404!...");
		}

		return new UserPrincipal(user);
	}

}
