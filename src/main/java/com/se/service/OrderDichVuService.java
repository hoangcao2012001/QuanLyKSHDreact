package com.se.service;

import java.util.List;

import com.se.entity.OrderDichVu;



public interface OrderDichVuService {
	public List<OrderDichVu> FindALL() ;
	public List<OrderDichVu> FindALLOrderByMaDP(int id) ;
	public OrderDichVu createOrderDV(OrderDichVu orderDichVu) ;
	public OrderDichVu updateOrderDV(OrderDichVu orderDichVu) ;
	public void deleteOrderDV(int maOrder) ;
}
