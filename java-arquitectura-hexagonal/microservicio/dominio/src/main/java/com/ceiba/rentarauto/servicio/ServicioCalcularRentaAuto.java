package com.ceiba.rentarauto.servicio;


import java.math.BigDecimal;
import java.time.LocalDate;

import com.ceiba.auto.modelo.dto.DtoAuto;
import com.ceiba.dominio.excepcion.ExcepcionDomingo;

public class ServicioCalcularRentaAuto {
	

	
	
	public Double ejecutar (DtoAuto auto, BigDecimal porcentaje, LocalDate fechaRenta, LocalDate fechaEntrega) throws ExcepcionDomingo {
		
		
		
		Double precioPorDia = auto.getPrecioPorDia();
		BigDecimal multiplicadorFinSemana = auto.getMultiplicadorFinSemana();
		Double precioPorDiaTarifaCombustible = porcentaje.doubleValue()*precioPorDia;
		Double precioPorDiaFinSemana = precioPorDiaTarifaCombustible * multiplicadorFinSemana.doubleValue();
		
		System.out.println("precioPorDia "+precioPorDia);
		return precioPorDiaTarifaCombustible;
		
	}
}
