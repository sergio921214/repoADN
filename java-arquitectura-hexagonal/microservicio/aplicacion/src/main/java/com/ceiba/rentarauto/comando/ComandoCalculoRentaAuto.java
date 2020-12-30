package com.ceiba.rentarauto.comando;



import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoCalculoRentaAuto{

    private String placa;
    private String fechaRenta;
    private String fechaEntrega;
    
}
