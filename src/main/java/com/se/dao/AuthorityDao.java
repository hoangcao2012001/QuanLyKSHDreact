package com.se.dao;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.se.entity.Authority;
import com.se.entity.Customer;


public interface AuthorityDao extends JpaRepository<Authority, Integer>{
	@Query("SELECT DISTINCT a FROM Authority a WHERE a.customer IN ?1")
	List<Authority> authoritiesOf(List<Customer> customer);
}
