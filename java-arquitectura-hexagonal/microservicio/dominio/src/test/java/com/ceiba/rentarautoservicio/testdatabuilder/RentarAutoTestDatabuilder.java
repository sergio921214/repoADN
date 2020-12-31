package com.ceiba.rentarautoservicio.testdatabuilder;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import com.ceiba.rentarauto.modelo.entidad.RentarAuto;

public class RentarAutoTestDatabuilder {

	private String placa;
	private LocalDate fechaRenta;
	private LocalDate fechaEntrega;
	private Double precioTotalRenta;

	public RentarAutoTestDatabuilder() {
		placa = "ABC123";
		fechaRenta = LocalDate.now();
		fechaEntrega = LocalDate.now().plus(3, ChronoUnit.DAYS);
		precioTotalRenta = 450000.0;

	}

	public RentarAutoTestDatabuilder conPlaca(String placa) {
		this.placa = placa;
		return this;
	}

	public RentarAutoTestDatabuilder conFechaRenta(LocalDate fechaRenta) {
		this.fechaRenta = fechaRenta;
		return this;
	}

	public RentarAutoTestDatabuilder conFechaEntrega(LocalDate fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
		return this;
	}

	public RentarAutoTestDatabuilder conPrecioTotalRenta(Double precioTotalRenta) {
		this.precioTotalRenta = precioTotalRenta;
		return this;
	}

	public RentarAuto build() {
		return new RentarAuto(placa, fechaRenta, fechaEntrega, precioTotalRenta);
	}
}
