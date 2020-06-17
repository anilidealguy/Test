package com.anil.learning;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BeanClass {

	@Autowired
	private String s1;

	public BeanClass() {}
	
	public BeanClass (String s1) {
		this.s1 = s1;
	}

	public String getS1() {
		return s1;
	}

	public void setS1(String s1) {
		this.s1 = s1;
	}
}
