package com.ceiba.auto.comando.manejador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import com.ceiba.auto.modelo.entidad.Auto;
import com.ceiba.auto.servicio.ServicioCrearAuto;


import org.springframework.stereotype.Component;

import com.ceiba.auto.comando.ComandoAuto;
import com.ceiba.auto.comando.fabrica.FabricaAuto;

@Component
public class ManejadorCrearAuto implements ManejadorComandoRespuesta<ComandoAuto, ComandoRespuesta<Long, Integer, String >> {

    private final FabricaAuto fabricaAuto;
    private final ServicioCrearAuto servicioCrearAuto;

    public ManejadorCrearAuto(FabricaAuto fabricaAuto, ServicioCrearAuto servicioCrearAuto) {
        this.fabricaAuto = fabricaAuto;
        this.servicioCrearAuto = servicioCrearAuto;
    }

    public ComandoRespuesta<Long, Integer, String > ejecutar(ComandoAuto comandoAuto) {
    	Auto auto = this.fabricaAuto.crear(comandoAuto);
        return new ComandoRespuesta<>(this.servicioCrearAuto.ejecutar(auto), 0, "succes");
    }
}
