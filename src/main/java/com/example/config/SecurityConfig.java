package com.example.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;




@Configuration
public class SecurityConfig {
	
	
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

		 http
				.authorizeHttpRequests(auth -> auth
						.requestMatchers("/addd").hasRole("ADMIN")
						.requestMatchers("/view").hasRole("USER")
						.requestMatchers("/register", "/login", "/css/**").permitAll()
						.anyRequest().authenticated()
						)
				 .formLogin(login -> login
			                .loginPage("/login")
			                .defaultSuccessUrl("/", true)
			                .permitAll()
			                )
				
				 .logout(logout -> logout
				            .logoutUrl("/logout") // The URL to trigger logout
				            .logoutSuccessUrl("/login?logout") // Redirect to login page after logout
				            .invalidateHttpSession(true) // Invalidate the session
				            .deleteCookies("JSESSIONID") // Delete the session cookie
				            .permitAll()
				        );
		 
				return http.build();
		         }
                @Bean
                 PasswordEncoder passwordEncoder() {
                  return new BCryptPasswordEncoder();
   }

}
