package com.anil.learning;

import org.springframework.beans.factory.annotation.Autowired;

public class Driver {
	
	@Autowired
	private BeanClass b;
	
	public void run() {
		System.out.println(this.b.getS1());
	}

}
