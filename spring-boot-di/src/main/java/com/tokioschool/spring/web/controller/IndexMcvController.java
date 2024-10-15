package com.tokioschool.spring.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.tokioschool.spring.web.service.IMyService;

@Controller
public class IndexMcvController {

	//@Autowired // ID via atributo
	private IMyService myService;

	@Autowired
	@Qualifier("stringComponent")
	private String name;
	
	@Autowired
	@Qualifier("stringComponent2")
	private String name2;
	
	@Value("${spring.application.name}")
	private String appName;
	
	// ID via Constructor
	@Autowired // Optional, si el arg es un component, Spring lo inyecta
	public IndexMcvController(@Qualifier("miServicioSimple") IMyService myService) {

		this.myService = myService;
	}


	@GetMapping({"","/","/index"})
	public String getIndexPageHandler(Model model) {
		model.addAttribute("title", appName);
		model.addAttribute("message", myService.operation()+", "+name+", "+name2);
		return "index";
	}
	
	/*
	// ID via setter
	@Autowired
	public void setMyService(IMyService service) {
		this.myService = service;
	}
	*/
}
