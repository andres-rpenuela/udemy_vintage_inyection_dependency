package com.tokioschool.spring.web.domain;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.Optional;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor @NoArgsConstructor
@Builder
public class ItemFactura {

	private Producto product;
	private BigDecimal cantidad;
	
	public BigDecimal calcularImporte() {
		final BigDecimal maybeCauntity = Optional.ofNullable(this.cantidad)
		.orElseGet(()->BigDecimal.ZERO);
		
		return Optional.ofNullable(this.product)
				.filter(product-> Objects.nonNull(product) && Objects.nonNull(product.getPrecio()))
				.map(product-> product.getPrecio().multiply(maybeCauntity) )
				.orElseGet(()->BigDecimal.ZERO);
	}
	 
}
