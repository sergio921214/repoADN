package com.ceiba.rentarautoservicio.testdatabuilder;

import com.ceiba.auto.modelo.dto.DtoAuto;

public class DtoAutoTestDataBuilder {

	private Long id;
	private String placa;
	private String tipoCombustible;
	private Boolean rentado;
	private Double precioPorDia;
	private Double multiplicadorFinSemana;

	public DtoAutoTestDataBuilder() {
		id = 1L;
		placa = "ABC321";
		tipoCombustible = "ELECTRICO";
		rentado = false;
		precioPorDia = 50000.0;
		multiplicadorFinSemana = 3.0;

	}

	public DtoAutoTestDataBuilder conPlaca(String placa) {
		this.placa = placa;
		return this;
	}

	public DtoAutoTestDataBuilder conTipoCombustible(String tipoCombustible) {
		this.tipoCombustible = tipoCombustible;
		return this;
	}

	public DtoAutoTestDataBuilder conPrecioPordia(Double precioPorDia) {
		this.precioPorDia = precioPorDia;
		return this;
	}

	public DtoAutoTestDataBuilder conMultiplicadorFinSemana(Double multiplicadorFinSemana) {
		this.multiplicadorFinSemana = multiplicadorFinSemana;
		return this;
	}

	public DtoAuto build() {
		return new DtoAuto(id, placa, tipoCombustible, rentado, precioPorDia, multiplicadorFinSemana);
	}
}
