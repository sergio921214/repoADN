package com.ceiba.auto.puerto.dao;

import com.ceiba.auto.modelo.dto.DtoAuto;


import java.util.List;

public interface DaoAuto {
	
    /**
     * Permite listar autos
     * @return los autos
     */
    List<DtoAuto> listar();
    
    /**
     * Permite listar autos disponibles
     * @return los autos disponibles
     */
    List<DtoAuto> listarDisponibles();
    
    /**
     * Permite listar autos
     * @return los autos rentados
     */
    List<DtoAuto> listarRentados();
    
    /**
     * Permite obtener auto por placa
     * @return auto por placa
     */
    DtoAuto obtenerAutoPorPlaca(String placa);
    
    
}
