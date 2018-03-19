package com.akshaythorve;

import java.security.Principal;
import java.util.LinkedHashMap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableOAuth2Sso
@RestController
@SpringBootApplication
public class SpringBootWebApplication extends WebSecurityConfigurerAdapter {


	@Override
    protected void configure(HttpSecurity http) throws Exception {

		http
		.csrf().disable()
		.authorizeRequests()

		.antMatchers("/api/**", "/dashboard", "/welcome").authenticated()
        .antMatchers("/**").permitAll()
        .anyRequest().authenticated()
        .and().logout().logoutSuccessUrl("/").permitAll();

  }
	  @RequestMapping("/user")
	  public Principal user(Principal principal) {

	      return principal;
	  }

	  @RequestMapping("/akshay")
	    public void user(OAuth2Authentication authentication) {
	        LinkedHashMap<String, Object> properties = (LinkedHashMap<String, Object>) authentication.getUserAuthentication().getDetails();

System.out.println("Authentication Object is: "+ properties);
	        System.out.println("User name is: "+ properties.get("name"));
	        System.out.println("User ID is: "+ properties.get("id"));


	    }

	public static void main(String[] args) throws Exception {
		SpringApplication.run(SpringBootWebApplication.class, args);
	}

}
