package com.ceiba.rentarautoservicio;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.mockito.Mockito;

import com.ceiba.BasePrueba;
import com.ceiba.auto.modelo.dto.DtoAuto;

import com.ceiba.auto.puerto.repositorio.RepositorioAuto;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.rentarauto.servicio.ServicioCalcularRentaAuto;
import com.ceiba.rentarautoservicio.testdatabuilder.DtoAutoTestDataBuilder;

public class ServicioCalcularRentaAutoTest {

	@Test
	public void validarNoExistenciaPreviaAuto() {
		// arrange
		DtoAuto dtoAuto = new DtoAutoTestDataBuilder().build();
		RepositorioAuto repositorioAuto = Mockito.mock(RepositorioAuto.class);
		Mockito.when(repositorioAuto.existe(Mockito.anyString())).thenReturn(false);
		ServicioCalcularRentaAuto servicioCalcularRentaAuto = new ServicioCalcularRentaAuto(repositorioAuto);
		// act - assert
		BasePrueba.assertThrows(() -> servicioCalcularRentaAuto.ejecutar(dtoAuto, 1.0, "2020-12-25", "2020-12-30"),
				ExcepcionDuplicidad.class, "El auto NO existe en el sistema");
	}
	
	@Test
	public void validarCalculoRentaAuto() {
		// arrange
		DtoAuto dtoAuto = new DtoAutoTestDataBuilder().build();
		RepositorioAuto repositorioAuto = Mockito.mock(RepositorioAuto.class);
		Mockito.when(repositorioAuto.existe(Mockito.anyString())).thenReturn(true);
		ServicioCalcularRentaAuto servicioCalcularRentaAuto = new ServicioCalcularRentaAuto(repositorioAuto);
		// act - assert
		assertEquals(450000.0, servicioCalcularRentaAuto.ejecutar(dtoAuto, 1.0, "2020-12-25", "2020-12-30"), 0);
		
	}

}
