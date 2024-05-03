package com.project.weekassignment.week2.beanexample;

import org.springframework.stereotype.Component;

@Component
public class Company {
	private Address address;

	public Company(Address address) {
		this.address = address;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(final Address address) {
		this.address = address;
	}
}
