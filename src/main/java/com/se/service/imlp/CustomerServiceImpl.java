package com.se.service.imlp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.se.dao.CustomerDao;
import com.se.entity.Customer;
import com.se.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {
@Autowired CustomerDao dao;
	
	@Override
	public List<Customer> FindAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public Customer FindCustomeṛ̣̣̣ById(String maKhachHang) {
		// TODO Auto-generated method stub
		return dao.findById(maKhachHang).get();
	}

	@Override
	public Customer FindCustomeṛ̣̣̣BySoCC(String soCC) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer createCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return dao.saveAndFlush(customer);
	}

	@Override
	public Customer saveCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return dao.saveAndFlush(customer);
	}

	@Override
	public void deleteCustomerByID(String maKhachHang) {
		dao.deleteById(maKhachHang);
	}

}
