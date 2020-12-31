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
	
	public AutoTestDataBuilder conTipoCombustible(String tipoCombustible) {
		this.tipoCombustible = tipoCombustible;
		return this;
	}
	
	public AutoTestDataBuilder conPrecioPordia(Double precioPorDia) {
		this.precioPorDia = precioPorDia;
		return this;
	}

	public AutoTestDataBuilder conMultiplicadorFinSemana(Double multiplicadorFinSemana) {
		this.multiplicadorFinSemana = multiplicadorFinSemana;
		return this;
	}
	
	public Auto build() {
		return new Auto(placa, tipoCombustible, rentado, precioPorDia, multiplicadorFinSemana);
	}
}