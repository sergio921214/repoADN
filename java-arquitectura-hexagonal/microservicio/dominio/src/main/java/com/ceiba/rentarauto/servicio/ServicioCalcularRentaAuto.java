package com.ceiba.rentarauto.servicio;


import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;

import com.ceiba.auto.modelo.dto.DtoAuto;
import com.ceiba.dominio.excepcion.ExcepcionDomingo;

public class ServicioCalcularRentaAuto {
	

	
	
	public Double ejecutar (DtoAuto auto, BigDecimal porcentaje, String fechaRenta, String fechaEntrega) throws ExcepcionDomingo, ParseException {
		
		
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
		
		/*
		 * ZoneId defaultZoneId = ZoneId.systemDefault(); Date fechaRentaDate =
		 * Date.from(fechaRenta.atStartOfDay(defaultZoneId).toInstant()); Date
		 * fechaEntregaDate =
		 * Date.from(fechaEntrega.atStartOfDay(defaultZoneId).toInstant());
		 */

		Calendar c1 = Calendar.getInstance();
		c1.setTime(fechaRenta);
		 
		Calendar c2 = Calendar.getInstance();
		c2.setTime(fechaEntrega);
		 
		int diasFinSemana = 0;
		 
		while(c2.after(c1)) {
		    if(c1.get(Calendar.DAY_OF_WEEK)!=Calendar.SUNDAY && c1.get(Calendar.DAY_OF_WEEK)!=Calendar.SATURDAY)
		    	diasFinSemana++;
		    c1.add(Calendar.DATE,1);
		}
		
		return diasFinSemana;
	}
	
	private Double calcularTotalRentaAuto(DtoAuto auto, BigDecimal porcentaje, String fechaRenta, String fechaEntrega  ) throws ParseException {
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MMM-dd");
		
		Date fechaRentaDate = formatter.parse(fechaRenta);
		Date fechaEntregaDate = formatter.parse(fechaEntrega);
		Double precioPorDia = auto.getPrecioPorDia();
		BigDecimal multiplicadorFinSemana = auto.getMultiplicadorFinSemana();
		Double precioPorDiaTarifaCombustible = porcentaje.doubleValue()*precioPorDia;
		Double precioPorDiaFinSemana = precioPorDiaTarifaCombustible * multiplicadorFinSemana.doubleValue();
		Integer diasFinSemana = contarDiasFinSemana(fechaRentaDate, fechaEntregaDate);
		Integer diasDeSemana = contarDiasDeSemana(fechaRentaDate, fechaRentaDate);
		Double precioTotalFinSemana = precioPorDiaFinSemana * diasFinSemana;
		Double precioTotalDiasDeSemana = precioPorDiaTarifaCombustible * diasDeSemana;
		 
		
		return precioTotalDiasDeSemana + precioTotalFinSemana;
		
	}
}
