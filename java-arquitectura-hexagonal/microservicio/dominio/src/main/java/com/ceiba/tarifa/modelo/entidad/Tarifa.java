package com.ceiba.tarifa.modelo.entidad;

import java.math.BigDecimal;


import lombok.Getter;

@Getter
public class Tarifa {

	
	private String tipoCombustible;
	private BigDecimal porcentaje;
	
	public Tarifa(String tipoCombustible, BigDecimal porcentaje) {
		
		this.tipoCombustible = tipoCombustible;
		this.porcentaje = porcentaje;
	}
	
	
}
