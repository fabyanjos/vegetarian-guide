package com.fabiale.vegetarianguide.service.impl;

import java.security.MessageDigest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.fabiale.vegetarianguide.model.User;
import com.fabiale.vegetarianguide.repositories.UserRepository;

@Component
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepository repository;

	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException, DataAccessException {

		User user = repository.findByLogin(username, null);
		
		if(user != null)
			return user;
		else {
			throw new UsernameNotFoundException("user not found");
		}
	}
	
	public static void main(String[] args)  throws Exception {
		String password = "1535892125";
		 
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(password.getBytes());
 
        byte byteData[] = md.digest();
 
        //convert the byte to hex format method 1
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < byteData.length; i++) {
         sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
        }
 
        System.out.println("Digest(in hex format):: " + sb.toString());
 
        //convert the byte to hex format method 2
        StringBuffer hexString = new StringBuffer();
    	for (int i=0;i<byteData.length;i++) {
    		String hex=Integer.toHexString(0xff & byteData[i]);
   	     	if(hex.length()==1) hexString.append('0');
   	     	hexString.append(hex);
    	}
    	System.out.println("Digest(in hex format):: " + hexString.toString());
	}
}
