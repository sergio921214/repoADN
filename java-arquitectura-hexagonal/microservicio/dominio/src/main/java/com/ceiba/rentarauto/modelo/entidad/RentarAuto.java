package com.ceiba.rentarauto.modelo.entidad;

import lombok.Getter;
import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

import java.time.LocalDate;

@Getter
public class RentarAuto {

	private static final String SE_DEBE_INGRESAR_LA_PLACA_DEL_AUTO_A_RENTAR = "Se debe ingresar la placa del auto a rentar";
	private static final String SE_DEBE_INGRESAR_LA_FECHA_DE_RENTA_DEL_AUTO = "Se debe ingresar la fecha de renta del auto";
	private static final String SE_DEBE_INGRESAR_LA_FECHA_DE_ENTREGA_DEL_AUTO = "Se debe ingresar la fecha de entrega del auto";
	private static final String SE_DEBE_INGRESAR_EL_PRECIO_TOTAL_DE_RENTA_DEL_AUTO = "Se debe ingresar el precio total de renta del auto";

	private String placa;
	private LocalDate fechaRenta;
	private LocalDate fechaEntrega;
	private Double precioTotalRenta;

	public RentarAuto(String placa, LocalDate fechaRenta, LocalDate fechaEntrega, Double precioTotalRenta) {

		validarObligatorio(placa, SE_DEBE_INGRESAR_LA_PLACA_DEL_AUTO_A_RENTAR);
		validarObligatorio(fechaRenta, SE_DEBE_INGRESAR_LA_FECHA_DE_RENTA_DEL_AUTO);
		validarObligatorio(fechaEntrega, SE_DEBE_INGRESAR_LA_FECHA_DE_ENTREGA_DEL_AUTO);
		validarObligatorio(precioTotalRenta, SE_DEBE_INGRESAR_EL_PRECIO_TOTAL_DE_RENTA_DEL_AUTO);

		this.placa = placa;
		this.fechaRenta = fechaRenta;
		this.fechaEntrega = fechaEntrega;
		this.precioTotalRenta = precioTotalRenta;
	}

}