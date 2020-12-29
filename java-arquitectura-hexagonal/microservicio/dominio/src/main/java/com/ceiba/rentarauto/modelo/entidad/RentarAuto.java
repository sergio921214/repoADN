package com.ceiba.rentarauto.modelo.entidad;
import lombok.Getter;




import java.time.LocalDate;




@Getter
public class RentarAuto {
	
    

    

    private String placa;
    private LocalDate fechaRenta;
    private LocalDate fechaEntrega;
    private Double precioTotalRenta;
    
	public RentarAuto(String placa, LocalDate fechaRenta, LocalDate fechaEntrega, Double precio) {
		
		
		
		
		this.placa = placa;
		this.fechaRenta = fechaRenta;
		this.fechaEntrega = fechaEntrega;
		this.precioTotalRenta = precio;
	}


}