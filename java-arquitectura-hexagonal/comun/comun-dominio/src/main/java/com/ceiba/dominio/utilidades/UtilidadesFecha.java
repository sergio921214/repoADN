package com.ceiba.dominio.utilidades;

import java.text.SimpleDateFormat;
import java.util.Date;

import java.text.ParseException;

public class UtilidadesFecha {
	
	  private UtilidadesFecha() {
		    
		  }


	  public static Date convertirStringADate(String fecha, String formato) {
		    try {
		      return new SimpleDateFormat(formato).parse(fecha);
		    } catch (ParseException e) {
		      return null;
		    }
	  }


}
