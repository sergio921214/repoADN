package com.ceiba.tarifa.consulta;

import java.util.List;

import com.ceiba.tarifa.puerto.dao.DaoTarifa;
import org.springframework.stereotype.Component;

import com.ceiba.tarifa.modelo.dto.DtoTarifa;

@Component
public class ManejadorListarTarifas {

    private final DaoTarifa daoTarifa;

    public ManejadorListarTarifas(DaoTarifa daoTarifa){
        this.daoTarifa = daoTarifa;
    }

    public List<DtoTarifa> ejecutar(){ return this.daoTarifa.listar(); 
    
    }
    }
