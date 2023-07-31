package com.se.service.imlp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.se.dao.RolesDao;
import com.se.entity.Roles;
import com.se.service.RolesService;
@Service
public class RolesServiceImpl implements RolesService{
@Autowired
RolesDao dao;
	@Override
	public List<Roles> findAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public Roles findById(String id) {
		// TODO Auto-generated method stub
		return dao.findById(id).get();
	}

	@Override
	public Roles create(Roles role) {
		// TODO Auto-generated method stub
		return dao.saveAndFlush(role);
	}

	@Override
	public Roles update(Roles role) {
		// TODO Auto-generated method stub
		return dao.saveAndFlush(role);
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		dao.deleteById(id);
	}

}
