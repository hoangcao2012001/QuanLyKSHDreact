package com.se.service;


import java.util.List;

import com.se.entity.Roles;


public interface RolesService {
	public List<Roles> findAll();
	public Roles findById(String id);
	public Roles create(Roles role);
	public Roles update(Roles role);
	public void delete(String id);
}
