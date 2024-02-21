package com.mywork.oauthsecurity.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Component;

import com.mywork.oauthsecurity.document.User;
import com.mywork.oauthsecurity.service.UserManager;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class JwtToUserConverter implements Converter<Jwt, UsernamePasswordAuthenticationToken> {

	@Autowired
	UserManager userManager;
	
	@Override
	public UsernamePasswordAuthenticationToken convert(Jwt jwt) {
//		User user= new User();
//		user.setId(jwt.getSubject());
		User user= (User) userManager.loadUserByUsername(jwt.getSubject());
		//log.info(user2+"hello");
		return new UsernamePasswordAuthenticationToken(user,jwt,user.getAuthorities());
	}
	

}
