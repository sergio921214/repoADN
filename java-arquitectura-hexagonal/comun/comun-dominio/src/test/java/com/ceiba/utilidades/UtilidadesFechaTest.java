package com.ceiba.utilidades;

import static org.junit.Assert.assertEquals;

import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

import com.ceiba.dominio.utilidades.UtilidadesFecha;

public class UtilidadesFechaTest {

	  @Test
	  public void convertirStringADateTest() {
	    // Crear calendar para test
	    Calendar cal = Calendar.getInstance();
	    cal.set(2020, 11, 25,0,0,0);
	    cal.set(Calendar.MILLISECOND, 0);
	    // Crear String de fecha
	    String strFecha = "2020-12-25";
	    // Obtener resultado
	    Date fecha = UtilidadesFecha.convertirStringADate(strFecha,"yyyy-MM-dd");
	    // Validar resultado
	    assertEquals(cal.getTime(), fecha);
	  }

}
