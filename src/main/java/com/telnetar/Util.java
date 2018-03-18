package com.telnetar;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Util {
	public static String hashPassword(String password){
		return new BCryptPasswordEncoder().encode(password);
	}
	
	public static void main(String args[]){
		System.out.println(hashPassword("clave"));
	}
}
