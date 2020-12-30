package com.ceiba.rentarauto.servicio;


import java.math.BigDecimal;


import java.util.Date;
import java.util.Calendar;
import com.ceiba.dominio.utilidades.UtilidadesFecha;

import com.ceiba.auto.modelo.dto.DtoAuto;


public class ServicioCalcularRentaAuto {
	

	
	
	public Double ejecutar (DtoAuto auto, BigDecimal porcentaje, String fechaRenta, String fechaEntrega) {
		
		
		return calcularTotalRentaAuto(auto,porcentaje,fechaRenta,fechaEntrega);
		
	}
	
	private Integer contarDiasFinSemana(Date fechaRenta, Date fechaEntrega) {

		
		Calendar c1 = Calendar.getInstance();
		c1.setTime(fechaRenta);
		 
		Calendar c2 = Calendar.getInstance();
		c2.setTime(fechaEntrega);
		 
		int diasFinSemana = 0;
		 
		while(c2.after(c1)) {
		    if(c1.get(Calendar.DAY_OF_WEEK)==Calendar.SUNDAY || c1.get(Calendar.DAY_OF_WEEK)==Calendar.SATURDAY)
		    	diasFinSemana++;
		    c1.add(Calendar.DATE,1);
		}
		
		return diasFinSemana;
	}
	
	private Integer contarDiasDeSemana(Date fechaRenta, Date fechaEntrega) {

		Calendar c1 = Calendar.getInstance();
		c1.setTime(fechaRenta);
		 
		Calendar c2 = Calendar.getInstance();
		c2.setTime(fechaEntrega);
		 
		int diasSemana = 0;
		 
		while(c2.after(c1)) {
		    if(c1.get(Calendar.DAY_OF_WEEK)!=Calendar.SATURDAY && c1.get(Calendar.DAY_OF_WEEK)!=Calendar.SUNDAY)
		    	diasSemana++;
		    c1.add(Calendar.DATE,1);
		}
		
		return diasSemana;
	}
	
	private Double calcularTotalRentaAuto(DtoAuto auto, BigDecimal porcentaje, String fechaRenta, String fechaEntrega  )   {
		
				
		Date fechaRentaDate = UtilidadesFecha.convertirStringADate(fechaRenta, "yyyy-MM-dd");
		Date fechaEntregaDate = UtilidadesFecha.convertirStringADate(fechaEntrega, "yyyy-MM-dd");
		Double precioPorDia = auto.getPrecioPorDia();
		BigDecimal multiplicadorFinSemana = auto.getMultiplicadorFinSemana();
		Double precioPorDiaTarifaCombustible = porcentaje.doubleValue()*precioPorDia;
		Double precioPorDiaFinSemana = precioPorDiaTarifaCombustible * multiplicadorFinSemana.doubleValue();
		Integer diasFinSemana = contarDiasFinSemana(fechaRentaDate, fechaEntregaDate);
		Integer diasDeSemana = contarDiasDeSemana(fechaRentaDate, fechaEntregaDate);
		Double precioTotalFinSemana = precioPorDiaFinSemana * diasFinSemana;
		Double precioTotalDiasDeSemana = precioPorDiaTarifaCombustible * diasDeSemana;
		 
		return precioTotalDiasDeSemana + precioTotalFinSemana;
		
	}
}
