package com.akshaythorve;

import java.util.LinkedHashMap;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Configuration
@EnableAutoConfiguration
@Controller
public class WelcomeController {

	@RequestMapping("/")
	public String welcomeSurvey(OAuth2Authentication authentication) {


		if(authentication!=null){

			LinkedHashMap<String, Object> properties = (LinkedHashMap<String, Object>) authentication.getUserAuthentication().getDetails();
System.out.println("===========================================");
System.out.println("Authentication Object is: "+ properties);
			System.out.println("User name is: "+ properties.get("name"));
			System.out.println("User ID is: "+ properties.get("id"));
		}



		return "index";
	}



	// test 5xx errors
	@RequestMapping("/5xx")
	public String ServiceUnavailable() {
		throw new RuntimeException("ABC");
	}




}
