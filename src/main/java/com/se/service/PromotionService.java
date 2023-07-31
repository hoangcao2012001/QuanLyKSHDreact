package com.se.service;

import java.util.List;

import com.se.entity.Promotion;


public interface PromotionService {
	public List<Promotion> findAll();
	public Promotion findById(String ma);
	public Promotion create(Promotion pro);
	public Promotion update(Promotion pro);
	public void delete(String id);
}
