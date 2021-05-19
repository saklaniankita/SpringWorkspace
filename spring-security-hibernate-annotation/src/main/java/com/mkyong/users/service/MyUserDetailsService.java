package com.mkyong.users.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mkyong.users.dao.UserDao;
import com.mkyong.users.model.UserRole;

@Service("userDetailsService")
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	private UserDao userDao;

	@Transactional(readOnly=true)
	@Override
	public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
	    System.out.println("********* 1"+username);
		com.mkyong.users.model.User user = userDao.findByUserName(username);  // our user roles and uname, password
		System.out.println(user.getPassword()+"*********"+user.getUsername()+"*****"+user.getUserRole());
		List<GrantedAuthority> result = new ArrayList<GrantedAuthority>();	
		
		for (UserRole userRole : user.getUserRole()) {
			System.out.println("$$$$$$$ "+userRole.getRole());
			result.add(new SimpleGrantedAuthority(userRole.getRole()));
		}
		
		
		User uu=new User(user.getUsername(), user.getPassword(), user.isEnabled(), true, true, true, result);
		return uu; // spring user
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}