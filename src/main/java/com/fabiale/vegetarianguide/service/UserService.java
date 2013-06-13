package com.fabiale.vegetarianguide.service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.fabiale.vegetarianguide.model.User;
import com.fabiale.vegetarianguide.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;

	public List<User> getAll() {
		return this.repository.getAll();
	}

	public Integer create(User user) {
		return this.repository.create(user);
	}
	
	public User findByName(String name) {
		return this.repository.findByName(name);
	}
	
	public User findByLogin(String login) {
		return this.repository.findByLogin(login);
	}
	
	public void authentication(User user) throws NoSuchAlgorithmException {
		user.setPass(this.md5(user.getPass()));
		
		User result = repository.findByLogin(user.getLogin());
		
		if(result != null) {
			if(result.getLogin().equals(user.getLogin()) && result.getPass().equals(user.getPass())) {
				user = result;
			} else {
				throw new BadCredentialsException("Falha na autenticação");
			}
		} else
			repository.create(user);
		
		Authentication authentication = new UsernamePasswordAuthenticationToken(user, null, AuthorityUtils.createAuthorityList("ROLE_USER"));
        SecurityContextHolder.getContext().setAuthentication(authentication);
	}
	
	private String md5(String pass) throws NoSuchAlgorithmException {
		 
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(pass.getBytes());
 
        byte byteData[] = md.digest();
 
        //convert the byte to hex format method 2
        StringBuffer hexString = new StringBuffer();
    	for (int i=0;i<byteData.length;i++) {
    		String hex=Integer.toHexString(0xff & byteData[i]);
   	     	if(hex.length()==1) hexString.append('0');
   	     	hexString.append(hex);
    	}
    	return hexString.toString();
	}
}
