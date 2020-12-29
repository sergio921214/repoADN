package com.ceiba.rentarauto.servicio;

import static com.ceiba.dominio.ValidadorArgumento.validarDomingo;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.ceiba.auto.modelo.dto.DtoAuto;
import com.ceiba.dominio.excepcion.ExcepcionDomingo;

public class ServicioSolicitarRentarAuto {
	
	private static final String NO_SE_PUEDE_RENTAR_AUTO_UN_DOMINGO = "No se puede rentar auto un domingo";
	
	
	public Double ejecutar (DtoAuto auto, BigDecimal porcentaje, LocalDate fechaRenta, LocalDate fechaEntrega) throws ExcepcionDomingo {
		
		validarDomingo(fechaRenta, NO_SE_PUEDE_RENTAR_AUTO_UN_DOMINGO);
		
		Double precioPorDia = auto.getPrecioPorDia();
		BigDecimal multiplicadorFinSemana = auto.getMultiplicadorFinSemana();
		Double precioPorDiaTarifaCombustible = porcentaje.doubleValue()*precioPorDia;
		Double precioPorDiaFinSemana = precioPorDiaTarifaCombustible * multiplicadorFinSemana.doubleValue();
		
		System.out.println("precioPorDia "+precioPorDia);
		return precioPorDiaTarifaCombustible;
		
	}
}
