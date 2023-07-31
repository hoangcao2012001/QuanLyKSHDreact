package com.se.service;

import com.se.entity.Token;

public interface TokenService {
    Token createToken(Token token);

    Token findByToken(String token);
}
