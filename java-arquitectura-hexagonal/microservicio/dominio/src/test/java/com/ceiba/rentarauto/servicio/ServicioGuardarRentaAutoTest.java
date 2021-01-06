package com.ceiba.rentarauto.servicio;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.mockito.Mockito;

import com.ceiba.BasePrueba;

import com.ceiba.auto.puerto.repositorio.RepositorioAuto;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.rentarauto.modelo.entidad.RentarAuto;
import com.ceiba.rentarauto.puerto.repositorio.RepositorioRentarAuto;

import com.ceiba.rentarautoservicio.testdatabuilder.RentarAutoTestDatabuilder;

public class ServicioGuardarRentaAutoTest {

	
	@Test
	public void validarExistenciaPreviaRentaAuto() {
		// arrange
		RentarAuto rentarAuto = new RentarAutoTestDatabuilder().build();
		RepositorioAuto repositorioAuto = Mockito.mock(RepositorioAuto.class);
		RepositorioRentarAuto repositorioRentarAuto = Mockito.mock(RepositorioRentarAuto.class);
		// Mockito.when(repositorioAuto.existe(Mockito.anyString())).thenReturn(true);
		Mockito.when(repositorioRentarAuto.existe(Mockito.anyString())).thenReturn(true);
		ServicioGuardarRentaAuto servicioGuardarRentaAuto = new ServicioGuardarRentaAuto(repositorioRentarAuto,
				repositorioAuto);
		// act - assert
		BasePrueba.assertThrows(() -> servicioGuardarRentaAuto.ejecutar(rentarAuto), ExcepcionValorInvalido.class,
				"La renta ya existe en el sistema");
	}

	@Test
	public void validarGuardarRentaAuto() {
		// arrange
		RentarAuto rentarAuto = new RentarAutoTestDatabuilder().build();
		RepositorioAuto repositorioAuto = Mockito.mock(RepositorioAuto.class);
		RepositorioRentarAuto repositorioRentarAuto = Mockito.mock(RepositorioRentarAuto.class);
		// Mockito.when(repositorioAuto.existe(Mockito.anyString())).thenReturn(true);
		Mockito.when(repositorioRentarAuto.existe(Mockito.anyString())).thenReturn(false);
		Mockito.when(repositorioRentarAuto.guardarRenta(rentarAuto)).thenReturn(1L);
		ServicioGuardarRentaAuto servicioGuardarRentaAuto = new ServicioGuardarRentaAuto(repositorioRentarAuto,
				repositorioAuto);
		Long resp = servicioGuardarRentaAuto.ejecutar(rentarAuto);
		// act - assert
		assertEquals(Long.valueOf(1L), resp);
	}
}
