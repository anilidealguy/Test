package com.anil.learning;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
	
	@Autowired
	@Qualifier(value = "V2")
	IDRParser parser;
	
	@Autowired
	String someTempVar;
	
	@RequestMapping("/hi")
	public String sayHello() {
		
		parser.parseJson("");
		return "Hello Anil";
	}
}
