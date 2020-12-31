package com.ceiba.auto.servicio;

import com.ceiba.auto.modelo.entidad.Auto;
import com.ceiba.auto.puerto.repositorio.RepositorioAuto;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExcepcionLongitudValor;
import com.ceiba.auto.servicio.testdatabuilder.AutoTestDataBuilder;
import org.junit.Test;
import org.mockito.Mockito;

import com.ceiba.BasePrueba;

public class ServicioCrearAutoTest {

    @Test
    public void validarPlacaLongitudIgual6() {
        // arrange
        AutoTestDataBuilder autoTestDataBuilder = new AutoTestDataBuilder().conPlaca("BC124");
        // act - assert
        BasePrueba.assertThrows(() -> autoTestDataBuilder.build(), ExcepcionLongitudValor.class, "La placa debe tener una longitud igual a 6");
    }

    @Test
    public void validarUsuarioExistenciaPreviaTest() {
        // arrange
        Auto auto = new AutoTestDataBuilder().build();
        RepositorioAuto repositorioAuto = Mockito.mock(RepositorioAuto.class);
        Mockito.when(repositorioAuto.existe(Mockito.anyString())).thenReturn(true);
        ServicioCrearAuto servicioCrearAuto = new ServicioCrearAuto(repositorioAuto);
        // act - assert
        BasePrueba.assertThrows(() -> servicioCrearAuto.ejecutar(auto), ExcepcionDuplicidad.class,"El auto ya existe en el sistema");
    }
}