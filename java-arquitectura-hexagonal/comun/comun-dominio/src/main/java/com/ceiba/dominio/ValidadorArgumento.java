package com.ceiba.dominio;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;

import com.ceiba.dominio.excepcion.ExcepcionLongitudValor;

import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import com.ceiba.dominio.excepcion.ExcepcionDomingo;

public final class ValidadorArgumento {

	private ValidadorArgumento() {
	}

	public static void validarObligatorio(Object valor, String mensaje) {
		if (valor == null) {
			throw new ExcepcionValorObligatorio(mensaje);
		}
	}

	public static void validarLongitud(String valor, int longitud, String mensaje) {
		if (valor.length() < longitud) {
			throw new ExcepcionLongitudValor(mensaje);
		}
	}

	public static void validarLongitudIgual(String valor, int longitud, String mensaje) {
		if (valor.length() != longitud) {
			throw new ExcepcionLongitudValor(mensaje);
		}
	}

	public static void validarDomingo(LocalDate valor, String mensaje) {
		if (valor.getDayOfWeek() == DayOfWeek.SUNDAY) {
			throw new ExcepcionDomingo(mensaje);
		}
	}

	public static void validarCantidadDigitosCadena(String valor, int cantidad, String mensaje) {
		ArrayList<Character> lista = new ArrayList<>();

		for (int i = 0; i < valor.length(); i++) {
			if (Character.isDigit(valor.charAt(i)))
				lista.add(valor.charAt(i));

		}
		if (lista.size() != cantidad) {
			throw new ExcepcionLongitudValor(mensaje);
		}
	}

}
