package com.ceiba.auto.servicio;

import org.junit.Test;
import org.mockito.Mockito;

import com.ceiba.BasePrueba;
import com.ceiba.auto.puerto.repositorio.RepositorioAuto;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;

public class ServicioRentarAutoTest {
	@Test
	public void validarNoExistenciaPreviaAutoTest() {
		// arrange

		RepositorioAuto repositorioAuto = Mockito.mock(RepositorioAuto.class);
		Mockito.when(repositorioAuto.existe(Mockito.anyString())).thenReturn(false);
		ServicioRentarAuto servicioRentarAuto = new ServicioRentarAuto(repositorioAuto);
		// act - assert
		BasePrueba.assertThrows(() -> servicioRentarAuto.ejecutar(Mockito.anyString()), ExcepcionValorInvalido.class,
				"El auto NO existe en el sistema");
	}

}
