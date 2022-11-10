package com.greatlearning.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class PasswordEncoderUtil {

	public static void main(String[] args) {
		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		
		String rawText = "HelloJava";
		String encodedPassword1 = passwordEncoder.encode(rawText);
		String encodedPassword2 = passwordEncoder.encode(rawText);
		String encodedPassword3 = passwordEncoder.encode(rawText);
		String encodedPassword4 = passwordEncoder.encode(rawText);

		System.out.println("Encoded password :: "+ encodedPassword1);
		System.out.println("Encoded password :: "+ encodedPassword2);
		System.out.println("Encoded password :: "+ encodedPassword3);
		System.out.println("Encoded password :: "+ encodedPassword4);

		System.out.println(passwordEncoder.matches(rawText, encodedPassword4));

	}
}
