package com.ceiba.rentarauto.comando.manejador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import com.ceiba.rentarauto.modelo.entidad.RentarAuto;
import com.ceiba.rentarauto.servicio.ServicioGuardarRentaAuto;


import org.springframework.stereotype.Component;

import com.ceiba.rentarauto.comando.ComandoRentarAuto;
import com.ceiba.rentarauto.comando.fabrica.FabricaRentarAuto;

@Component
public class ManejadorCrearRentarAuto implements ManejadorComandoRespuesta<ComandoRentarAuto, ComandoRespuesta<Long >> {

    private final FabricaRentarAuto fabricaRentarAuto;
    private final ServicioGuardarRentaAuto servicioGuardarRentaAuto;

    public ManejadorCrearRentarAuto(FabricaRentarAuto fabricaRentarAuto, ServicioGuardarRentaAuto servicioGuardarRentaAuto) {
        this.fabricaRentarAuto = fabricaRentarAuto;
        this.servicioGuardarRentaAuto = servicioGuardarRentaAuto;
    }

    public ComandoRespuesta<Long> ejecutar(ComandoRentarAuto comandoRentarAuto) {
    	RentarAuto rentarAuto = this.fabricaRentarAuto.crear(comandoRentarAuto);
    	System.out.println("esta es la entidad rentar auto " + rentarAuto.getPlaca());
        return new ComandoRespuesta<>(this.servicioGuardarRentaAuto.ejecutar(rentarAuto));
    }
}