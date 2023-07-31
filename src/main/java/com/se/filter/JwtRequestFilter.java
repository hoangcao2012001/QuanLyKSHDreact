package com.se.filter;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import com.se.dao.CustomerDao;
import com.se.entity.Customer;
import com.se.entity.Token;
import com.se.service.JwtService;
import com.se.service.TokenService;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class JwtRequestFilter extends UsernamePasswordAuthenticationFilter {
	private final static String TOKEN_HEADER = "Authorization";
 
	@Autowired
    private JwtService jwtservice;
	@Autowired
	private CustomerDao CSdao;
    @Autowired
    private TokenService verificationTokenService;

    private String getJwtFromRequest(HttpServletRequest  request) {
    	String bearerToken = request.getHeader("Authorization");
    	if (StringUtils.hasText(bearerToken)&&bearerToken.startsWith("Bearer ")) {
			return bearerToken.substring(7);
		}
    	return null;
    }
    
    @Override
    public void doFilter(ServletRequest request,
    		ServletResponse response,
                                    FilterChain filterChain)
            throws ServletException, IOException {
    	HttpServletRequest httpRequest = (HttpServletRequest) request;
        String authToken = httpRequest.getHeader(TOKEN_HEADER);
        System.out.println(authToken);
       if (jwtservice.validateTokenLogin(authToken)) {
		String username = jwtservice.getUserFromToken(authToken);
		System.out.println(username);
		Customer user = CSdao.findById(username).get();
		System.out.println(user.getAuthorities());
			if (username != null) {
				boolean enabled = true;
				boolean accountNonExpired = true;
				boolean credentialsNonExpired = true;
				boolean accountNonLocked = true;
				  Set<GrantedAuthority> authorities = new HashSet<>();
		            user.getAuthorities().forEach(
		                    p -> authorities.add(new SimpleGrantedAuthority(p.getRole().getId())));
		            System.out.println(authorities);
				UserDetails userDetails = new User(username, user.getPassword(), enabled , accountNonExpired
						,credentialsNonExpired, accountNonLocked, authorities);
				  UsernamePasswordAuthenticationToken authentication =
		                    new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());

		            authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(httpRequest));
		            System.err.println(authentication);
		            SecurityContextHolder.getContext().setAuthentication(authentication);
			}
       }
        filterChain.doFilter(request, response);
    }
}
