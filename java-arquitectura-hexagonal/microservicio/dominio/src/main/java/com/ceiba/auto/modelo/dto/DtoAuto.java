package com.ceiba.auto.modelo.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public class DtoAuto {
	private String placa;
	private String tipoCombustible;
	private Double precioPorDia;
	private Double multiplicadorFinSemana;
}
