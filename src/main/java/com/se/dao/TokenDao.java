package com.se.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.se.entity.Token;

public interface TokenDao extends JpaRepository<Token, Long> {
	 Token findByToken(String token);
}
