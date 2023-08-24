package com.spring.pos.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class TestController {
	
	@GetMapping("/test")
	public List<String> test(HttpServletRequest request) {
		List<String> names= new ArrayList<String>();
		names.add("jame");
		names.add("john");
		return names;
	}

}
