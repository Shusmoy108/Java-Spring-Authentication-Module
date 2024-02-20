package com.mywork.oauthsecurity.service;

import java.text.MessageFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Service;

import com.mywork.oauthsecurity.document.User;
import com.mywork.oauthsecurity.repository.UserRepository;


@Service
public class UserManager implements UserDetailsManager {

	@Autowired 
	UserRepository userRepository;
	
	@Autowired
	PasswordEncoder passwordEncoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		return userRepository.findByUsername(username).orElseThrow(()->	new UsernameNotFoundException(MessageFormat.format("username {0}  not found", username)));
	
	}

	@Override
	public void createUser(UserDetails user) {
		((User) user).setPassword(passwordEncoder.encode(user.getPassword()));
		userRepository.save((User)user);
		
	}

	@Override
	public void updateUser(UserDetails user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteUser(String username) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void changePassword(String oldPassword, String newPassword) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean userExists(String username) {
		
		return userRepository.existsByUsername(username);
	}
}
