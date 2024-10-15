package com.tokioschool.spring.web.service.impl;

import org.springframework.stereotype.Component;

import com.tokioschool.spring.web.service.IMyService;

@Component("miServicioSimple")		
public class MyServiceImpl implements IMyService {

	@Override
	public String operation() {
		return "Hola desde MyService Simple";
	}

}
