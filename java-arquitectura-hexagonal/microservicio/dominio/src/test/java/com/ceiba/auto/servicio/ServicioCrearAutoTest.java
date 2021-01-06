package com.ceiba.auto.servicio;

import com.ceiba.auto.modelo.entidad.Auto;
import com.ceiba.auto.puerto.repositorio.RepositorioAuto;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.auto.servicio.testdatabuilder.AutoTestDataBuilder;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.mockito.Mockito;

import com.ceiba.BasePrueba;

public class ServicioCrearAutoTest {

    @Test
    public void validarAutoExistenciaPreviaTest() {
        // arrange
        Auto auto = new AutoTestDataBuilder().build();
        RepositorioAuto repositorioAuto = Mockito.mock(RepositorioAuto.class);
        Mockito.when(repositorioAuto.existe(Mockito.anyString())).thenReturn(true);
        ServicioCrearAuto servicioCrearAuto = new ServicioCrearAuto(repositorioAuto);
        // act - assert
        BasePrueba.assertThrows(() -> servicioCrearAuto.ejecutar(auto), ExcepcionValorInvalido.class,"El auto ya existe en el sistema");
    }
    
	@Test
	public void validarCrearAutoTest() {
		// arrange
		Auto auto = new AutoTestDataBuilder().build();
		RepositorioAuto repositorioAuto = Mockito.mock(RepositorioAuto.class);
		Mockito.when(repositorioAuto.existe(Mockito.anyString())).thenReturn(false);
		Mockito.when(repositorioAuto.crear(auto)).thenReturn(1L);
		ServicioCrearAuto servicioCrearAuto = new ServicioCrearAuto(repositorioAuto);
		Long resp = servicioCrearAuto.ejecutar(auto);
		// act - assert
		assertEquals(Long.valueOf(1L), resp);
	}
}