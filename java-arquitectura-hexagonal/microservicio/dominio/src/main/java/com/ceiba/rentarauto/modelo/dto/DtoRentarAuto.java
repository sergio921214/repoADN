package com.ceiba.rentarauto.modelo.dto;
import lombok.AllArgsConstructor;
import lombok.Getter;


import java.time.LocalDate;


@Getter
@AllArgsConstructor
public class DtoRentarAuto {
    private Long id;
    private String placa;
    private LocalDate fechaRenta;
    private LocalDate fechaEntrega;
    private Double precioTotalRenta;
}
