package com.fabiale.vegetarianguide.service.impl;

import java.security.NoSuchAlgorithmException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.fabiale.vegetarianguide.model.User;
import com.fabiale.vegetarianguide.repositories.UserRepository;
import com.fabiale.vegetarianguide.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository repository;

	public Integer create(User user) {
		return this.repository.create(user);
	}
	
	public User findByName(String name) {
		return this.repository.findByName(name);
	}
	
	public User findByLogin(String login) {
		return null;
	}
	
	public void authentication(User user) throws NoSuchAlgorithmException {
//		user.setPass(this.md5(user.getPass()));
		
		User result = repository.findByLogin(user.getEmail(), user.getNetwork());
		
		if(result != null) {
			if(result.getEmail().equals(user.getEmail())) {
				user = result;
			} else {
				throw new BadCredentialsException("Falha na autentica��o");
			}
		} else
			repository.create(user);
		
		Authentication authentication = new UsernamePasswordAuthenticationToken(user, null, AuthorityUtils.createAuthorityList("ROLE_USER"));
        SecurityContextHolder.getContext().setAuthentication(authentication);
	}
	
//	private String md5(String pass) throws NoSuchAlgorithmException {
//		 
//        MessageDigest md = MessageDigest.getInstance("MD5");
//        md.update(pass.getBytes());
// 
//        byte byteData[] = md.digest();
// 
//        //convert the byte to hex format method 2
//        StringBuffer hexString = new StringBuffer();
//    	for (int i=0;i<byteData.length;i++) {
//    		String hex=Integer.toHexString(0xff & byteData[i]);
//   	     	if(hex.length()==1) hexString.append('0');
//   	     	hexString.append(hex);
//    	}
//    	return hexString.toString();
//	}
}
