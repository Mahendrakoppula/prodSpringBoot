package com.cors.cors;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class CorsApplication {


	public static final String YELLOW = "\u001B[33m";
	public static final String GREEN = "\u001B[32m";

	@Value("${server.port}")
	private static String serverPort ="8081";

	public static void main(String[] args) {
		SpringApplication.run(CorsApplication.class, args);

			System.out.println(GREEN + "·✴· ·✴· ·✴· ·✴· ·✴· ·✴· ·✴· ·✴· ·✴· ·✴·" );
			System.out.println(YELLOW + "App is running on http://localhost:" + serverPort );
			System.out.println(GREEN + "·✴· ·✴· ·✴· ·✴· ·✴· ·✴· ·✴· ·✴· ·✴· ·✴·" );
	}

	@GetMapping("/")
	public String helloWorld() {
		return "Hello, World!";
	}


}
