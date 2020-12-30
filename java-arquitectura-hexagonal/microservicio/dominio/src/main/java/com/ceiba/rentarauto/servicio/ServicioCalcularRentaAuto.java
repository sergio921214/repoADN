package com.ceiba.rentarauto.servicio;


import java.math.BigDecimal;
import java.util.Date;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;

import com.ceiba.auto.modelo.dto.DtoAuto;
import com.ceiba.dominio.excepcion.ExcepcionDomingo;

public class ServicioCalcularRentaAuto {
	

	
	
	public Double ejecutar (DtoAuto auto, BigDecimal porcentaje, LocalDate fechaRenta, LocalDate fechaEntrega) throws ExcepcionDomingo {
		
		
		return calcularTotalRentaAuto(auto,porcentaje,fechaRenta,fechaEntrega);
		
	}
	
	private Integer contarDiasFinSemana(LocalDate fechaRenta, LocalDate fechaEntrega) {
		ZoneId defaultZoneId = ZoneId.systemDefault();
		Date fechaRentaDate = Date.from(fechaRenta.atStartOfDay(defaultZoneId).toInstant());
		Date fechaEntregaDate = Date.from(fechaEntrega.atStartOfDay(defaultZoneId).toInstant());
		
		Calendar c1 = Calendar.getInstance();
		c1.setTime(fechaRentaDate);
		 
		Calendar c2 = Calendar.getInstance();
		c2.setTime(fechaEntregaDate);
		 
		int diasFinSemana = 0;
		 
		while(c2.after(c1)) {
		    if(c1.get(Calendar.DAY_OF_WEEK)==Calendar.SUNDAY || c1.get(Calendar.DAY_OF_WEEK)==Calendar.SATURDAY)
		    	diasFinSemana++;
		    c1.add(Calendar.DATE,1);
		}
		
		return diasFinSemana;
	}
	
	private Integer contarDiasDeSemana(LocalDate fechaRenta, LocalDate fechaEntrega) {
		
		ZoneId defaultZoneId = ZoneId.systemDefault();
		Date fechaRentaDate = Date.from(fechaRenta.atStartOfDay(defaultZoneId).toInstant());
		Date fechaEntregaDate = Date.from(fechaEntrega.atStartOfDay(defaultZoneId).toInstant());
		
		Calendar c1 = Calendar.getInstance();
		c1.setTime(fechaRentaDate);
		 
		Calendar c2 = Calendar.getInstance();
		c2.setTime(fechaEntregaDate);
		 
		int diasFinSemana = 0;
		 
		while(c2.after(c1)) {
		    if(c1.get(Calendar.DAY_OF_WEEK)!=Calendar.SUNDAY && c1.get(Calendar.DAY_OF_WEEK)!=Calendar.SATURDAY)
		    	diasFinSemana++;
		    c1.add(Calendar.DATE,1);
		}
		
		return diasFinSemana;
	}
	
	private Double calcularTotalRentaAuto(DtoAuto auto, BigDecimal porcentaje, LocalDate fechaRenta, LocalDate fechaEntrega  ) {
		
		Double precioPorDia = auto.getPrecioPorDia();
		BigDecimal multiplicadorFinSemana = auto.getMultiplicadorFinSemana();
		Double precioPorDiaTarifaCombustible = porcentaje.doubleValue()*precioPorDia;
		Double precioPorDiaFinSemana = precioPorDiaTarifaCombustible * multiplicadorFinSemana.doubleValue();
		Integer diasFinSemana = contarDiasFinSemana(fechaRenta, fechaEntrega);
		Integer diasDeSemana = contarDiasDeSemana(fechaRenta, fechaEntrega);
		Double precioTotalFinSemana = precioPorDiaFinSemana * diasFinSemana;
		Double precioTotalDiasDeSemana = precioPorDiaTarifaCombustible * diasDeSemana;
		 
		
		return precioTotalDiasDeSemana + precioTotalFinSemana;
		
	}
}
