package com.ceiba.rentarautoservicio;

import org.junit.Test;
import org.mockito.Mockito;

import com.ceiba.BasePrueba;

import com.ceiba.auto.puerto.repositorio.RepositorioAuto;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;

import com.ceiba.rentarauto.modelo.entidad.RentarAuto;
import com.ceiba.rentarauto.puerto.repositorio.RepositorioRentarAuto;

import com.ceiba.rentarauto.servicio.ServicioGuardarRentaAuto;

import com.ceiba.rentarautoservicio.testdatabuilder.RentarAutoTestDatabuilder;

public class ServicioGuardarRentaAutoTest {

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

	@Test
	public void validarExistenciaPreviaRentaAuto() {
		// arrange
		RentarAuto rentarAuto = new RentarAutoTestDatabuilder().build();
		RepositorioAuto repositorioAuto = Mockito.mock(RepositorioAuto.class);
		RepositorioRentarAuto repositorioRentarAuto = Mockito.mock(RepositorioRentarAuto.class);
		//Mockito.when(repositorioAuto.existe(Mockito.anyString())).thenReturn(true);
		Mockito.when(repositorioRentarAuto.existe(Mockito.anyString())).thenReturn(true);
		ServicioGuardarRentaAuto servicioGuardarRentaAuto = new ServicioGuardarRentaAuto(repositorioRentarAuto,
				repositorioAuto);
		// act - assert
		BasePrueba.assertThrows(() -> servicioGuardarRentaAuto.ejecutar(rentarAuto), ExcepcionDuplicidad.class,
				"La renta ya existe en el sistema");
	}
}
