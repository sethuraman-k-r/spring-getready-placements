package com.spring.getready.services;

import java.io.UnsupportedEncodingException;
import java.util.UUID;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class Trial {

	public static void main(String[] args) throws UnsupportedEncodingException {
		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);
		String password = "Admin@ABC";
		System.out.println(passwordEncoder.encode(password));
//		UUID uuid = UUID.nameUUIDFromBytes(new String("admin@spring.ats").getBytes("utf-8"));
//		System.out.println(uuid);
	}
	
}
