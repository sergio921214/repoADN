package com.ceiba.rentarauto.modelo.entidad;

import static com.ceiba.dominio.ValidadorArgumento.validarDomingo;

import java.time.LocalDate;

import lombok.Getter;

@Getter
public class CalculoRentaAuto {
	
	private static final String NO_SE_PUEDE_RENTAR_AUTO_UN_DOMINGO = "No se puede rentar auto un domingo";
	
    private String placa;
    private LocalDate fechaRenta;
    private LocalDate fechaEntrega;
    
	public CalculoRentaAuto(String placa, LocalDate fechaRenta, LocalDate fechaEntrega) {
		
		validarDomingo(fechaRenta, NO_SE_PUEDE_RENTAR_AUTO_UN_DOMINGO);
		
		this.placa = placa;
		this.fechaRenta = fechaRenta;
		this.fechaEntrega = fechaEntrega;
	}


}
