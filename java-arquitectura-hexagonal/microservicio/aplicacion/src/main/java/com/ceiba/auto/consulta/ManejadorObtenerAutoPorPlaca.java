package com.ceiba.auto.consulta;


import org.springframework.stereotype.Component;

import com.ceiba.auto.modelo.dto.DtoAuto;
import com.ceiba.auto.puerto.dao.DaoAuto;

@Component
public class ManejadorObtenerAutoPorPlaca {
	
    private final DaoAuto daoAuto;

    public ManejadorObtenerAutoPorPlaca(DaoAuto daoAuto){
        this.daoAuto = daoAuto;
    }

    public DtoAuto ejecutar(String placa){ return this.daoAuto.obtenerAutoPorPlaca(placa); 
    
    }

}
