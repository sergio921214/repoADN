package com.ceiba.auto.consulta;

import java.util.List;

import com.ceiba.auto.puerto.dao.DaoAuto;
import org.springframework.stereotype.Component;

@Component
public class ManejadorListarPlacasDisponibles {

    private final DaoAuto daoAuto;

    public ManejadorListarPlacasDisponibles(DaoAuto daoAuto){
        this.daoAuto = daoAuto;
    }

    public List<String> ejecutar(){ return this.daoAuto.listarPlacasDisponibles(); 
    
    }
    }

