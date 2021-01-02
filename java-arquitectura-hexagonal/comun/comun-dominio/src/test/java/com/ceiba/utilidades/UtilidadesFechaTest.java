package com.ceiba.utilidades;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;

import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

import com.ceiba.dominio.utilidades.UtilidadesFecha;

public class UtilidadesFechaTest {

	@Test
	public void convertirStringADateTest() {
		// Crear calendar para test
		Calendar cal = Calendar.getInstance();
		cal.set(2020, 11, 25, 0, 0, 0);
		cal.set(Calendar.MILLISECOND, 0);
		// Crear String de fecha
		String strFecha = "2020-12-25";
		// Obtener resultado
		Date fecha = UtilidadesFecha.convertirStringADate(strFecha, "yyyy-MM-dd");
		// Validar resultado
		assertEquals(cal.getTime(), fecha);
	}

	@Test
	public void validarFormatoFechaInvalidoTest() {
		// Crear calendar para test
		Calendar cal = Calendar.getInstance();
		cal.set(2020, 11, 25, 0, 0, 0);
		cal.set(Calendar.MILLISECOND, 0);
		// Crear String de fecha
		String strFecha = "2020/12/25";
		// Obtener resultado
		BasePrueba.assertThrows(() -> UtilidadesFecha.convertirStringADate(strFecha, "yyyy-MM-dd"),
				ExcepcionValorInvalido.class, "Se debe ingresar un formato de fecha yyyy-mm-dd");
	}

	@Test
	public void contarDiasFinSemanaTest() {
		// Crear calendar para test
		Calendar cal1 = Calendar.getInstance();
		Calendar cal2 = Calendar.getInstance();
		cal1.set(2020, 11, 25, 0, 0, 0);
		cal1.set(Calendar.MILLISECOND, 0);
		cal2.set(2020, 11, 30, 0, 0, 0);
		cal2.set(Calendar.MILLISECOND, 0);

		// Assert
		assertTrue(UtilidadesFecha.contarDiasFinSemana(cal1.getTime(), cal2.getTime()) == 2);
	}

	@Test
	public void contarDiasSemanaTest() {
		// Crear calendar para test
		Calendar cal1 = Calendar.getInstance();
		Calendar cal2 = Calendar.getInstance();
		cal1.set(2020, 11, 25, 0, 0, 0);
		cal1.set(Calendar.MILLISECOND, 0);
		cal2.set(2020, 11, 30, 0, 0, 0);
		cal2.set(Calendar.MILLISECOND, 0);

		// Assert
		assertTrue(UtilidadesFecha.contarDiasDeSemana(cal1.getTime(), cal2.getTime()) == 3);
	}
}
