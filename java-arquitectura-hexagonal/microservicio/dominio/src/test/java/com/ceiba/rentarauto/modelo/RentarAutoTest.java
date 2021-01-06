package com.ceiba.rentarauto.modelo;

import org.junit.Test;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import com.ceiba.rentarautoservicio.testdatabuilder.RentarAutoTestDatabuilder;

public class RentarAutoTest {
	
	@Test
	public void validarPlacaIsNull() {
		RentarAutoTestDatabuilder rentarAutoTestDatabuilder = new RentarAutoTestDatabuilder().conPlaca(null);
		BasePrueba.assertThrows(() -> rentarAutoTestDatabuilder.build(), ExcepcionValorObligatorio.class,
				"Se debe ingresar la placa del auto a rentar");
	}

	@Test
	public void validarFechaRentaIsNull() {
		RentarAutoTestDatabuilder rentarAutoTestDatabuilder = new RentarAutoTestDatabuilder().conFechaRenta(null);
		BasePrueba.assertThrows(() -> rentarAutoTestDatabuilder.build(), ExcepcionValorObligatorio.class,
				"Se debe ingresar la fecha de renta del auto");
	}

	@Test
	public void validarFechaEntregaIsNull() {
		RentarAutoTestDatabuilder rentarAutoTestDatabuilder = new RentarAutoTestDatabuilder().conFechaEntrega(null);
		BasePrueba.assertThrows(() -> rentarAutoTestDatabuilder.build(), ExcepcionValorObligatorio.class,
				"Se debe ingresar la fecha de entrega del auto");
	}

	@Test
	public void validarPrecioTotalRentaIsNull() {
		RentarAutoTestDatabuilder rentarAutoTestDatabuilder = new RentarAutoTestDatabuilder().conPrecioTotalRenta(null);
		BasePrueba.assertThrows(() -> rentarAutoTestDatabuilder.build(), ExcepcionValorObligatorio.class,
				"Se debe ingresar el precio total de renta del auto");
	}


}
