package com.ceiba.auto.comando.fabrica;

import com.ceiba.auto.modelo.entidad.Auto;
import org.springframework.stereotype.Component;

import com.ceiba.auto.comando.ComandoAuto;

@Component
public class FabricaAuto {

    public Auto crear(ComandoAuto comandoAuto) {
        return new Auto(        		
        		comandoAuto.getPlaca(),
        		comandoAuto.getTipoCombustible(),
        		comandoAuto.getRentado(),
        		comandoAuto.getPrecioPorDia(),
        		comandoAuto.getMultiplicadorFinSemana()
        );
    }

}