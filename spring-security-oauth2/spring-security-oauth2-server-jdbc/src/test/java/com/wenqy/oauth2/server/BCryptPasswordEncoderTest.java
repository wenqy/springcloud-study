package com.wenqy.oauth2.server;

import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BCryptPasswordEncoderTest {

	@Test
	public void testBCryptPasswordEncoder() {
		// 生成密文
		// $2a$10$0lzwE/ePEynMI0pH0Styf.jUjukcMK3pjYnstJ44A63b9R4z4FAyi
		System.out.println(new BCryptPasswordEncoder().encode("secret"));
	}
}
