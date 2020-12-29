package com.ceiba.auto.modelo.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public class DtoAuto {
	private Long id;
	private String placa;
	private String tipoCombustible;
	private Boolean rentado;
	private Double precioPorDia;
	private BigDecimal multiplicadorFinSemana;
}
