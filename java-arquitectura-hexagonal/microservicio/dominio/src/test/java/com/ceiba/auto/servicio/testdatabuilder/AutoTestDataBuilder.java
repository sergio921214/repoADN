package com.ceiba.auto.servicio.testdatabuilder;

import com.ceiba.auto.modelo.entidad.Auto;

public class AutoTestDataBuilder {

	private String placa;
	private String tipoCombustible;
	private Boolean rentado;
	private Double precioPorDia;
	private Double multiplicadorFinSemana;

	public AutoTestDataBuilder() {
		placa = "ABC123";
		tipoCombustible = "GAS";
		rentado = false;
		precioPorDia = 25000.0;
		multiplicadorFinSemana = 2.0;

	}

	public AutoTestDataBuilder conPlaca(String placa) {
		this.placa = placa;
		return this;
	}

	public Auto build() {
		return new Auto(placa, tipoCombustible, rentado, precioPorDia, multiplicadorFinSemana);
	}
}