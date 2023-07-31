package com.se.service.imlp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.se.dao.AuthorityDao;
import com.se.entity.Authority;
import com.se.service.AuthorityService;
@Service
public class AuthorityServiceImpl implements AuthorityService {
@Autowired
AuthorityDao dao;
	@Override
	public List<Authority> findAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public Authority findById(Integer id) {
		// TODO Auto-generated method stub
		return dao.findById(id).get();
	}

	@Override
	public Authority create(Authority auth) {
		// TODO Auto-generated method stub
		return dao.saveAndFlush(auth);
	}

	@Override
	public Authority update(Authority auth) {
		// TODO Auto-generated method stub
		return dao.saveAndFlush(auth);
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		dao.deleteById(id);
	}

}
