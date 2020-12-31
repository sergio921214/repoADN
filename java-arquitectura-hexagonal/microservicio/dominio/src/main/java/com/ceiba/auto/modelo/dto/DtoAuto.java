package com.ceiba.auto.modelo.dto;


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
	private Double multiplicadorFinSemana;
}
