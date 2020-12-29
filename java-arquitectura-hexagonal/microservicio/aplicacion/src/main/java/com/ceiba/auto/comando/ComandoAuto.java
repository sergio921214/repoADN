package com.ceiba.auto.comando;



import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoAuto{

    private String placa;
    private String tipoCombustible;
    private Boolean rentado;
	private Double precioPorDia;
	private BigDecimal multiplicadorFinSemana;
}
