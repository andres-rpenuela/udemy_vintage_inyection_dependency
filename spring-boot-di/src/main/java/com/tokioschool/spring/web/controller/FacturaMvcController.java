package com.tokioschool.spring.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tokioschool.spring.web.domain.Factura;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/web/facturas")
@RequiredArgsConstructor
public class FacturaMvcController {
	
	private final Factura factura;
	
	@GetMapping({"","/","/ver"})
	public String showFacturaHandler(Model model) {
		model.addAttribute("title", "Ejemplo de inyección de dependneica");
		model.addAttribute("factura", factura);
		return "facturas/ver";
	}

}
