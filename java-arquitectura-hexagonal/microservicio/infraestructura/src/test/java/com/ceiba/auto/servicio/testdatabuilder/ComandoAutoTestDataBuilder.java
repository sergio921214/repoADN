package com.ceiba.auto.servicio.testdatabuilder;

import com.ceiba.auto.comando.ComandoAuto;

public class ComandoAutoTestDataBuilder {

	private String placa;
	private String tipoCombustible;
	private Boolean rentado;
	private Double precioPorDia;
	private Double multiplicadorFinSemana;

	public ComandoAutoTestDataBuilder() {
		placa = "ABC123";
		tipoCombustible = "GASOLINA";
		rentado = false;
		precioPorDia = 50000.0;
		multiplicadorFinSemana = 3.0;

	}

	public ComandoAutoTestDataBuilder conPlaca(String placa) {
		this.placa = placa;
		return this;
	}

	public ComandoAuto build() {
		return new ComandoAuto(placa, tipoCombustible, rentado, precioPorDia, multiplicadorFinSemana);
	}

}
