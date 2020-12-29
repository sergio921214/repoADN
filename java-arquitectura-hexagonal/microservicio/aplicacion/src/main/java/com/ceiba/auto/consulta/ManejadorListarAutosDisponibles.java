package com.ceiba.auto.consulta;

import java.util.List;

import com.ceiba.auto.puerto.dao.DaoAuto;
import org.springframework.stereotype.Component;

import com.ceiba.auto.modelo.dto.DtoAuto;

@Component
public class ManejadorListarAutosDisponibles {

    private final DaoAuto daoAuto;

    public ManejadorListarAutosDisponibles(DaoAuto daoAuto){
        this.daoAuto = daoAuto;
    }

    public List<DtoAuto> ejecutar(){ return this.daoAuto.listarDisponibles(); 
    
    }
    }
