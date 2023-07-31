package com.se.entity;
import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;


import lombok.Data;


@SuppressWarnings("serial")
@Data
@Entity
@Table(name = "tbl_authorities", uniqueConstraints = {
		@UniqueConstraint(columnNames = {"Customer_id", "Role_id"})
})
public class Authority  implements Serializable{
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@ManyToOne @JoinColumn(name = "Customer_id")
	private Customer customer;
	@ManyToOne  @JoinColumn(name = "Role_id")
	private Roles role;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Customer getUsers() {
		return customer;
	}
	public void setUsers(Customer users) {
		this.customer = users;
	}
	public Roles getRole() {
		return role;
	}
	public void setRole(Roles role) {
		this.role = role;
	}
	
}
