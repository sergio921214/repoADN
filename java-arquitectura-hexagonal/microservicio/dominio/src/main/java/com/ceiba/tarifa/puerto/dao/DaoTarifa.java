package com.ceiba.tarifa.puerto.dao;

import com.ceiba.tarifa.modelo.dto.DtoTarifa;


import java.util.List;

public interface DaoTarifa {
	
    /**
     * Permite listar tarifas
     * @return las tarifas
     */
    List<DtoTarifa> listar();
    
    /**
     * Permite obtener una tarifa por tipoCombustible
     * @return tarifa por tipoCombustible
     */
    DtoTarifa obtenerTarifaPorTipoCombustible(String tipoCombustible);
    
    
}
