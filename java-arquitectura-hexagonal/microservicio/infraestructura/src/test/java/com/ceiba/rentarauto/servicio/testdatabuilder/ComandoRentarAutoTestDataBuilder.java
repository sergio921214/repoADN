package com.ceiba.rentarauto.servicio.testdatabuilder;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import com.ceiba.rentarauto.comando.ComandoRentarAuto;

public class ComandoRentarAutoTestDataBuilder {

	private String placa;
	private LocalDate fechaRenta;
	private LocalDate fechaEntrega;
	private Double precioTotalRenta;

	public ComandoRentarAutoTestDataBuilder() {
		placa = "ABC123";
		fechaRenta = LocalDate.now();
		fechaEntrega = LocalDate.now().plus(3, ChronoUnit.DAYS);
		precioTotalRenta = 450000.0;
	}

	public ComandoRentarAutoTestDataBuilder conPlaca(String placa) {
		this.placa = placa;
		return this;
	}

	public ComandoRentarAutoTestDataBuilder conFechaRenta(LocalDate fechaRenta) {
		this.fechaRenta = fechaRenta;
		return this;
	}

	public ComandoRentarAutoTestDataBuilder conFechaEntrega(LocalDate fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
		return this;
	}

	public ComandoRentarAutoTestDataBuilder conPrecioTotalRenta(Double precioTotalRenta) {
		this.precioTotalRenta = precioTotalRenta;
		return this;
	}

	public ComandoRentarAuto build() {
		return new ComandoRentarAuto(placa, fechaRenta, fechaEntrega, precioTotalRenta);
	}

}
