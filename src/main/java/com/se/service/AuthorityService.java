package com.se.service;

import java.util.List;

import com.se.entity.Authority;


public interface AuthorityService {
	public List<Authority> findAll();
	public Authority findById(Integer id);
	public Authority create(Authority auth);
	public Authority update(Authority auth);
	public void delete(Integer id);
}
