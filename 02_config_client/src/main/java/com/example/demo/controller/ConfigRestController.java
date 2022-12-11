package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.prop.ConfigPropertiesHolder;

@RestController
public class ConfigRestController {
	
	
	private ConfigPropertiesHolder propertiesHolder;
	
	@Autowired
	public ConfigRestController(ConfigPropertiesHolder propertiesHolder) {
		this.propertiesHolder = propertiesHolder;
	}

	@GetMapping("/configserver/test")
	public String getConfigs() {
		return propertiesHolder.toString();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
