package com.tokioschool.spring.web.configuration;

import java.math.BigDecimal;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.tokioschool.spring.web.domain.Cliente;
import com.tokioschool.spring.web.domain.ItemFactura;
import com.tokioschool.spring.web.domain.Producto;

@Configuration
public class ItemsConfiguration {

	@Bean
	@Primary
	public Cliente cliente() {
		return Cliente.builder().nombre("andres")
				.apellidos("Ruiz Peñuela")
				.build();
	}
	
	@Bean(name="itemsFactura")
	@Primary
	public List<ItemFactura> items(){
		final Producto product1 = Producto.builder().nombre("Camara Sony").precio(new BigDecimal(100)).build();
		final Producto product2 = Producto.builder().nombre("Biciblieta Bianchi aro 26").precio(new BigDecimal(200)).build();
		
		return Arrays.asList( new ItemFactura(product1, new BigDecimal(2)),new ItemFactura(product2, new BigDecimal(4)));
	}
	
	@Bean(name="itemsFacturaOffice")
	public List<ItemFactura> itemsOffice(){
		final Producto product1 = Producto.builder().nombre("Monitor LG LCD 24").precio(new BigDecimal(100)).build();
		final Producto product2 = Producto.builder().nombre("Notebook Asus").precio(new BigDecimal(200)).build();
		final Producto product3 = Producto.builder().nombre("Impresora HP Multifuncional").precio(new BigDecimal(80)).build();
		final Producto product4 = Producto.builder().nombre("Escritorio Oficina").precio(new BigDecimal(300)).build();
		return Arrays.asList( 
				new ItemFactura(product1, new BigDecimal(2)),
				new ItemFactura(product2, new BigDecimal(4)),
				new ItemFactura(product3, new BigDecimal(1)),
				new ItemFactura(product4, new BigDecimal(1))
				);
	}
}
