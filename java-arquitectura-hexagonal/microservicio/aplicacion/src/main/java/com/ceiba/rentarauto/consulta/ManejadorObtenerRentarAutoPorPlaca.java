package com.ceiba.rentarauto.consulta;

import org.springframework.stereotype.Component;

import com.ceiba.rentarauto.modelo.dto.DtoRentarAuto;
import com.ceiba.rentarauto.puerto.dao.DaoRentarAuto;

@Component
public class ManejadorObtenerRentarAutoPorPlaca {
	
    private final DaoRentarAuto daoRentarAuto;

    public ManejadorObtenerRentarAutoPorPlaca(DaoRentarAuto daoRentarAuto){
        this.daoRentarAuto = daoRentarAuto;
    }

    public DtoRentarAuto ejecutar(String placa){ return this.daoRentarAuto.obtenerRentaPorPlaca(placa); 
    
    }

}