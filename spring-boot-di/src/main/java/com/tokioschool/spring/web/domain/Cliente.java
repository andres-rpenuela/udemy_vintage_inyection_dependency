package com.tokioschool.spring.web.domain;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@Data
@AllArgsConstructor @NoArgsConstructor
@Builder
public class Cliente {
	@Value("${cliente.nombre}")
	private String nombre;
	
	@Value("${cliente.apellidos}")
	private String apellidos;
	
}
