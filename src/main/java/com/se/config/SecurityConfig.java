package com.se.config;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.se.authentication.CustomAccessDeniedHandler;
import com.se.authentication.RestauthenticationEnTryPoint;
import com.se.entity.Customer;
import com.se.filter.JwtRequestFilter;
import com.se.service.CustomerService;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Bean
	public JwtRequestFilter jwtRequestFilter() throws Exception{
		JwtRequestFilter jwtRequestFilter = new JwtRequestFilter();
		jwtRequestFilter.setAuthenticationManager(authenticationManager());
		return jwtRequestFilter;
	}
	 @Bean
	    public CorsFilter corsFilter() {
	        CorsConfiguration corsConfiguration = new CorsConfiguration();
	        corsConfiguration.setAllowedOrigins(Collections.singletonList("http://localhost:3000"));
	        corsConfiguration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
	        corsConfiguration.setAllowedHeaders(Collections.singletonList("*"));
	        corsConfiguration.setAllowCredentials(true);

	        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
	        source.registerCorsConfiguration("/**", corsConfiguration);

	        return new CorsFilter(source);
	 }
	@Autowired
	CustomerService Service;

	@Autowired
	BCryptPasswordEncoder pe;
	

	//cung cap nguon dl dang nhap
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.userDetailsService(username -> {
//			try {
//				Customer user = Service.FindCustomeṛ̣̣̣ById(username);
//				String password = user.getPassword();
//				/*
//				 * Boolean active = user.getIsActive(); 
//				 * Boolean delete = user.getIsDisable();
//				 * Boolean isActive = false; if (active == false || delete == true) { isActive =
//				 * true; }
//				 */
//				String[] roles = user.getAuthorities().stream().map(er -> er.getRole().getId())
//						.collect(Collectors.toList()).toArray(new String[0]);
//				System.err.println( User.withUsername(username).password(pe.encode(password)).roles(roles).build());
//				return User.withUsername(username).password(pe.encode(password)).roles(roles).build();
//			} catch (Exception e) {
//				throw new UsernameNotFoundException(username + " not found");
//			}
//		});
//	}

//phan quyen truy cap
	@Bean
	@Override
	protected AuthenticationManager authenticationManager() throws Exception {
		return super.authenticationManager();
	}
	@Bean
	public RestauthenticationEnTryPoint restauthenticationEnTryPoint(){
		return new RestauthenticationEnTryPoint();
	}
	
	@Bean 
	public CustomAccessDeniedHandler customAccessDeniedHandler() {
		return new CustomAccessDeniedHandler();
	}
	@Override
	  protected void configure(HttpSecurity http) throws Exception {
	  http.csrf().ignoringAntMatchers("/rest/**");
        http.authorizeRequests(requests -> requests.antMatchers("/rest/login**","/rest/phong/**","/rest/loaiphong/**","/rest/datphong/**").permitAll());
        http.antMatcher("/rest/**").httpBasic(basic -> basic.authenticationEntryPoint(restauthenticationEnTryPoint())).sessionManagement(management -> management.sessionCreationPolicy(SessionCreationPolicy.STATELESS)).authorizeRequests(requests -> requests
//	  .antMatchers("/user/repass", "/user/change","/admin/**").authenticated()// kiểm tra đăng nhập
                
                .exceptionHandling(handling -> handling.accessDeniedHandler(customAccessDeniedHandler()));
        http.formLogin(login -> login.loginPage("/user/sign-in").loginProcessingUrl(
                "/user/sign-in").defaultSuccessUrl("/sign-in/success",
                false).failureUrl("/user/sign-in/erro").permitAll());
        http.rememberMe(me -> me.tokenValiditySeconds(86400));
        http.exceptionHandling(handling -> handling.accessDeniedPage("/user/unauthoried"));
        http.logout(logout -> logout.logoutUrl("/user/logoff").logoutSuccessUrl(
                "/user/logoff/success")); 
	  } // Oauth2 }
	 
//	//co che ma hoa mat khau
	@Bean
	public BCryptPasswordEncoder getpPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

//	
//	// cho phep truy xuat rest api tu ben ngoai
//	public void configure(WebSecurity web) throws Exception {
//		web.ignoring().antMatchers(HttpMethod.OPTIONS, "/**");
//	}
}
