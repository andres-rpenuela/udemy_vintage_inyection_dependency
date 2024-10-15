package com.tokioschool.spring.web.service.impl;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.tokioschool.spring.web.service.IMyService;

@Component("miServiceComplejo")		
@Primary // permite seleccionar el candidato a inyectar por defecto
public class MyServiceComplejoImpl implements IMyService {

	@Override
	public String operation() {
		return "Hola desde MyService Complejo";
	}

}
