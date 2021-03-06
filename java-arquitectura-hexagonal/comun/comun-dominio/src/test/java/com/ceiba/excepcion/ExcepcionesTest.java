package com.ceiba.excepcion;

import org.junit.Test;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.ValidadorArgumento;
import com.ceiba.dominio.excepcion.ExcepcionLongitudValor;

import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;


public class ExcepcionesTest {

	@Test
	public void validarObligatorioTest() {

		// Obtener resultado
		BasePrueba.assertThrows(() -> ValidadorArgumento.validarObligatorio(null, "valor obligatorio"),
				ExcepcionValorObligatorio.class, "valor obligatorio");

	}

	@Test
	public void validarLongitudTest() {

		// Obtener resultado
		BasePrueba.assertThrows(() -> ValidadorArgumento.validarLongitud("aut", 4, "longitud invalida"),
				ExcepcionLongitudValor.class, "longitud invalida");

	}
	
	@Test
	public void validarLongitudIgualTest() {

		// Obtener resultado
		BasePrueba.assertThrows(() -> ValidadorArgumento.validarLongitudIgual("aut", 4, "longitud invalida"),
				ExcepcionLongitudValor.class, "longitud invalida");

	}
}
