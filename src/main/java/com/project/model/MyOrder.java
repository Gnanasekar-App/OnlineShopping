package com.project.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class MyOrder {

	public Integer getOrderid() {
		return orderid;
	}

	public void setOrderid(Integer orderid) {
		this.orderid = orderid;
	}

	public LocalDateTime getLocaldtetime() {
		return localdtetime;
	}

	public void setLocaldtetime(LocalDateTime localdtetime) {
		this.localdtetime = localdtetime;
	}

	public String getOrderstatus() {
		return orderstatus;
	}

	public void setOrderstatus(String orderstatus) {
		this.orderstatus = orderstatus;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<Products> getProductlist() {
		return productlist;
	}

	public void setProductlist(List<Products> productlist) {
		this.productlist = productlist;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Integer orderid;
	
	LocalDateTime localdtetime;
	String orderstatus;
	
	@OneToOne(cascade = CascadeType.ALL)
	Customer customer;

	@OneToMany(cascade = CascadeType.ALL)
	List<Products>productlist;
	
	@OneToOne(cascade = CascadeType.ALL)
	Address address;
}
