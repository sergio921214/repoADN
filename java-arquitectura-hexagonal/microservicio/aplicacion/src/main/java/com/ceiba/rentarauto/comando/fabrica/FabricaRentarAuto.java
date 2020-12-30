package com.ceiba.rentarauto.comando.fabrica;

import com.ceiba.rentarauto.modelo.entidad.RentarAuto;
import org.springframework.stereotype.Component;

import com.ceiba.rentarauto.comando.ComandoRentarAuto;

@Component
public class FabricaRentarAuto {

    public RentarAuto crear(ComandoRentarAuto comandoRentarAuto) {
        return new RentarAuto(        		
        		comandoRentarAuto.getPlaca(),
        		comandoRentarAuto.getFechaRenta(),
        		comandoRentarAuto.getFechaEntrega(),
        		comandoRentarAuto.getPrecioRenta()
        		
        );
    }

}
