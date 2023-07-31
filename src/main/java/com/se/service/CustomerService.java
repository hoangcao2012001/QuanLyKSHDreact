package com.se.service;

import java.util.List;

import com.se.entity.Customer;

public interface CustomerService {
	public List <Customer> FindAll();
	public  Customer FindCustomeṛ̣̣̣ById(String maKhachHang);
	public  Customer FindCustomeṛ̣̣̣BySoCC(String soCC);
	
	public Customer createCustomer(Customer customer);
	public Customer saveCustomer(Customer customer);
	public void deleteCustomerByID(String maKhachHang);
}
