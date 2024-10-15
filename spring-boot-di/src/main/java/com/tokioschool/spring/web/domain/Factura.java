package com.tokioschool.spring.web.domain;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.annotation.ApplicationScope;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;

import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@Data	
@AllArgsConstructor @NoArgsConstructor
@Builder
//@Scope(scopeName = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Scope(scopeName = WebApplicationContext.SCOPE_REQUEST)
//@RequestScope //  scope: Un compoente por cada peticion
//@SessionScope // scope: Se inyecta en la session y dura lo que una sesion dura (se cierra el navegador, invalida la sesion, se invalida la sesion) y debe implementar serializable
//@ApplicationScope // una instnacia para toda la aplicacion a nivel de ServletContext
public class Factura implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	private Cliente cliente;
	@Autowired
	@Qualifier("itemsFacturaOffice")
	private List<ItemFactura> items;
	
	@Value("${factura.descripcion}")
	private String descripcion;
	
	@PostConstruct
	public void inicializar() {
		cliente.setNombre(cliente.getNombre().concat(" José")); // si es requestScope se va concatentando " Jose" en cada peticion
		this.descripcion = this.descripcion.concat(" del cliente: %s".formatted(this.cliente.getNombre() ));
	}
	
}
