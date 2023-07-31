package com.se.service.imlp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.se.dao.OrderDichVuDao;
import com.se.entity.OrderDichVu;
import com.se.service.OrderDichVuService;
@Service
public class OrderDichVuServiceImpl implements OrderDichVuService{
	@Autowired OrderDichVuDao dao;

	@Override
	public List<OrderDichVu> FindALLOrderByMaDP(int id) {
		// TODO Auto-generated method stub
		return dao.FindALLOrderByMaDP(id);
	}

	@Override
	public OrderDichVu createOrderDV(OrderDichVu orderDichVu) {
		// TODO Auto-generated method stub
		return dao.saveAndFlush(orderDichVu);
	}

	@Override
	public OrderDichVu updateOrderDV(OrderDichVu orderDichVu) {
		// TODO Auto-generated method stub
		System.out.print(orderDichVu.getMaDatPhong());
		return dao.saveAndFlush(orderDichVu);
	}

	@Override
	public void deleteOrderDV(int maOrder) {
		// TODO Auto-generated method stub
		dao.deleteById(maOrder);
	}

	@Override
	public List<OrderDichVu> FindALL() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

}
