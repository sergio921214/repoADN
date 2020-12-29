package com.ceiba.auto.comando.manejador;



import com.ceiba.manejador.ManejadorComando;
import com.ceiba.auto.modelo.entidad.Auto;
import com.ceiba.auto.servicio.ServicioCambiarRentadoAuto;
import org.springframework.stereotype.Component;

import com.ceiba.auto.comando.ComandoAuto;
import com.ceiba.auto.comando.fabrica.FabricaAuto;

@Component
public class ManejadorRentarAuto implements ManejadorComando<ComandoAuto> {

    private final FabricaAuto fabricaAuto;
    private final ServicioCambiarRentadoAuto servicioRentarAuto;

    public ManejadorRentarAuto(FabricaAuto fabricaAuto, ServicioCambiarRentadoAuto servicioRentarAuto) {
        this.fabricaAuto = fabricaAuto;
        this.servicioRentarAuto = servicioRentarAuto;
    }

    public void ejecutar(ComandoAuto comandoAuto) {
    	Auto auto = this.fabricaAuto.crear(comandoAuto);
        this.servicioRentarAuto.ejecutar(auto);
    }
}