package com.se.service.imlp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.se.dao.TokenDao;
import com.se.entity.Token;
import com.se.service.TokenService;


@Service
public class TokenServiceImpl implements TokenService {

    @Autowired
    private TokenDao tokendao;

    public Token createToken(Token token) {
        return tokendao.saveAndFlush(token);
    }

    @Override
    public Token findByToken(String token) {
        return tokendao.findByToken(token);
    }
}

