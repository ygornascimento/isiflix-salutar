package br.com.isiflix.salutar.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//		http.csrf(csrf -> csrf.disable())
//			.authorizeHttpRequests(auth -> auth
//					.requestMatchers(HttpMethod.POST, "/usuarios").permitAll()
//					.requestMatchers(HttpMethod.POST, "/login").permitAll()
//					.anyRequest().authenticated())
//			.sessionManagement(sess -> sess.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
//					.httpBasic(Customizer.withDefaults())
//					.build();
//		http.addFilterBefore(new MyFilter(), UsernamePasswordAuthenticationFilter.class);
//		
//		return http.build();
		
        return http.csrf(csrf -> csrf.disable())
                .sessionManagement(sm -> sm.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(authorize -> authorize.requestMatchers(HttpMethod.POST, "/login").permitAll()
                .requestMatchers(HttpMethod.POST, "/usuarios").permitAll()
                .anyRequest().authenticated())
                .addFilterBefore(new MyFilter(), UsernamePasswordAuthenticationFilter.class)
                .build();
	}
}
