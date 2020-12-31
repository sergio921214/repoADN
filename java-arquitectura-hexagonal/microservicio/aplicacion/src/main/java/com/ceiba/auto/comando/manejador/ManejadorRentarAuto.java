package com.ceiba.auto.comando.manejador;

import com.ceiba.manejador.ManejadorComando;
import com.ceiba.auto.servicio.ServicioRentarAuto;
import org.springframework.stereotype.Component;


@Component
public class ManejadorRentarAuto implements ManejadorComando<String> {


    private final ServicioRentarAuto servicioRentarAuto;

    public ManejadorRentarAuto( ServicioRentarAuto servicioRentarAuto) {
        
        this.servicioRentarAuto = servicioRentarAuto;
    }

    public void ejecutar(String placa) {
    	
        this.servicioRentarAuto.ejecutar(placa);
    }
}