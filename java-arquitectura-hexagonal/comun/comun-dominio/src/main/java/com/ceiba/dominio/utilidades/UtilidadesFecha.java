package com.ceiba.dominio.utilidades;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;

import java.text.ParseException;

public class UtilidadesFecha  {
	
	private static final String SE_DEBE_INGRESAR_UN_FORMATO_DE_FECHA_YYYYMMDD = "Se debe ingresar un formato de fecha yyyy-mm-dd";

	private UtilidadesFecha() {

	}

	public static Date convertirStringADate(String fecha, String formato) {
		try {
			return new SimpleDateFormat(formato).parse(fecha);
		} catch (ParseException e) {
			throw new ExcepcionValorInvalido(SE_DEBE_INGRESAR_UN_FORMATO_DE_FECHA_YYYYMMDD) ;
		}
	}
	
	public static Integer contarDiasFinSemana(Date fechaRenta, Date fechaEntrega) {

		Calendar c1 = Calendar.getInstance();
		c1.setTime(fechaRenta);

		Calendar c2 = Calendar.getInstance();
		c2.setTime(fechaEntrega);

		int diasFinSemana = 0;

		while (c2.after(c1)) {
			if (c1.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY || c1.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY)
				diasFinSemana++;
			c1.add(Calendar.DATE, 1);
		}

		return diasFinSemana;
	}

	public static Integer contarDiasDeSemana(Date fechaRenta, Date fechaEntrega) {

		Calendar c1 = Calendar.getInstance();
		c1.setTime(fechaRenta);

		Calendar c2 = Calendar.getInstance();
		c2.setTime(fechaEntrega);

		int diasSemana = 0;

		while (c2.after(c1)) {
			if (c1.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY && c1.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY)
				diasSemana++;
			c1.add(Calendar.DATE, 1);
		}

		return diasSemana;
	}

}
