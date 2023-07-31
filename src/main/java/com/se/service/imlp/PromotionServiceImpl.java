package com.se.service.imlp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.se.dao.PromotionDao;
import com.se.entity.Promotion;
import com.se.service.PromotionService;
@Service
public class PromotionServiceImpl implements PromotionService {
@Autowired
PromotionDao dao;
	@Override
	public List<Promotion> findAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public Promotion findById(String ma) {
		// TODO Auto-generated method stub
		return dao.findById(ma).get();
	}

	@Override
	public Promotion create(Promotion pro) {
		// TODO Auto-generated method stub
		return dao.saveAndFlush(pro);
	}

	@Override
	public Promotion update(Promotion pro) {
		// TODO Auto-generated method stub
		return dao.saveAndFlush(pro);
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		dao.deleteById(id);
	}

}
