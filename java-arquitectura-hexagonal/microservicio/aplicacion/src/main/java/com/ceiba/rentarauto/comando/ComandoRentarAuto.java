package com.ceiba.rentarauto.comando;


import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoRentarAuto{

	private String placa;
	private LocalDate fechaRenta;
	private LocalDate fechaEntrega;
	private Double precioTotalRenta;
}
