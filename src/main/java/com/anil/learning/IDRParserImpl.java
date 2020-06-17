package com.anil.learning;

import org.springframework.stereotype.Component;

@Component("V1")
public class IDRParserImpl implements IDRParser {

	@Override
	public void parseJson(String str) {
		// TODO Auto-generated method stub
		System.out.println("Inside IDR parser Impl");
	}

}
