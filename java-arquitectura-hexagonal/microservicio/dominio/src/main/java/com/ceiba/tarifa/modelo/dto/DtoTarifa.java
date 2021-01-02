package com.ceiba.tarifa.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DtoTarifa {
	private Long id;
	private String tipoCombustible;
	private Double porcentaje;
}