package com.ceiba.rentarauto.consulta;

import com.ceiba.rentarauto.puerto.dao.DaoRentarAuto;

import java.util.List;

import org.springframework.stereotype.Component;

import com.ceiba.rentarauto.modelo.dto.DtoRentarAuto;

@Component
public class ManejadorListarRentarAuto {

    private final DaoRentarAuto daoRentarAuto;

    public ManejadorListarRentarAuto(DaoRentarAuto daoRentarAuto){
        this.daoRentarAuto = daoRentarAuto;
    }

    public List<DtoRentarAuto> ejecutar(){ return this.daoRentarAuto.listar();}
    }