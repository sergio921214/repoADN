package com.ceiba.tarifa.consulta;

import org.springframework.stereotype.Component;

import com.ceiba.tarifa.modelo.dto.DtoTarifa;
import com.ceiba.tarifa.puerto.dao.DaoTarifa;

@Component
public class ManejadorObtenerTarifaPorTipoCombustible {
	
    private final DaoTarifa daoTarifa;

    public ManejadorObtenerTarifaPorTipoCombustible(DaoTarifa daoTarifa){
        this.daoTarifa = daoTarifa;
    }

    public DtoTarifa ejecutar(String tipoCombustible){
    	return this.daoTarifa.obtenerTarifaPorTipoCombustible(tipoCombustible); 
    }

}