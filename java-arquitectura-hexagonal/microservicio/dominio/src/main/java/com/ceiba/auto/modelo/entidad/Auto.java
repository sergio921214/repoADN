package com.ceiba.auto.modelo.entidad;


import lombok.Getter;
import static com.ceiba.dominio.ValidadorArgumento.validarLongitudIgual;
import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

import static com.ceiba.dominio.ValidadorArgumento.validarCantidadDigitosCadena;

@Getter
public class Auto {

	private static final String SE_DEBE_INGRESAR_LA_PLACA = "Se debe ingresar la placa del Auto";
	private static final String SE_DEBE_INGRESAR_EL_TIPO_COMBUSTIBLE = "Se debe ingresar el tipo de combustible";
	private static final String SE_DEBE_INGRESAR_EL_PRECIO_POR_DIA = "Se debe ingresar el precio por dia";
	private static final String SE_DEBE_INGRESAR_EL_MULTIPLICADOR_FIN_SEMANA = "Se debe ingresar el multiplicador fin semana";
	private static final String LA_PLACA_DEBE_TENER_UNA_LONGITUD_IGUAL_A = "La placa debe tener una longitud igual a %s";
	private static final String LA_PLACA_DEBE_TENER_TRES_DIGITOS = "La placa debe tener %s digitos";

	private static final int LONGITUD_PLACA = 6;
	private static final int CANTIDAD_DIGITOS_PLACA = 3;

	private String placa;
	private String tipoCombustible;
	private Boolean rentado;
	private Double precioPorDia;
	private Double multiplicadorFinSemana;

	public Auto(String placa, String tipoCombustible, Boolean rentado, Double precioPorDia,
			Double multiplicadorFinSemana) {

		validarObligatorio(placa, SE_DEBE_INGRESAR_LA_PLACA);
		validarObligatorio(tipoCombustible, SE_DEBE_INGRESAR_EL_TIPO_COMBUSTIBLE);
		validarObligatorio(precioPorDia, SE_DEBE_INGRESAR_EL_PRECIO_POR_DIA);
		validarObligatorio(multiplicadorFinSemana, SE_DEBE_INGRESAR_EL_MULTIPLICADOR_FIN_SEMANA);
		validarLongitudIgual(placa, LONGITUD_PLACA, String.format(LA_PLACA_DEBE_TENER_UNA_LONGITUD_IGUAL_A,LONGITUD_PLACA));
		validarCantidadDigitosCadena(placa, CANTIDAD_DIGITOS_PLACA, String.format(LA_PLACA_DEBE_TENER_TRES_DIGITOS,CANTIDAD_DIGITOS_PLACA));
		

		this.placa = placa;
		this.tipoCombustible = tipoCombustible;
		this.rentado = rentado;
		this.precioPorDia = precioPorDia;
		this.multiplicadorFinSemana = multiplicadorFinSemana;
	}

}
