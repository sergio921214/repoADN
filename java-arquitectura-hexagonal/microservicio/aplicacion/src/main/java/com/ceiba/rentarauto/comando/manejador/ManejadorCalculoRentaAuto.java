package com.ceiba.rentarauto.comando.manejador;



import com.ceiba.manejador.ManejadorComandoRespuesta;
import com.ceiba.rentarauto.comando.ComandoCalculoRentaAuto;

import com.ceiba.rentarauto.servicio.ServicioCalcularRentaAuto;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.stereotype.Component;

import com.ceiba.ComandoRespuesta;

import com.ceiba.auto.puerto.dao.DaoAuto;
import com.ceiba.tarifa.puerto.dao.DaoTarifa;
import com.ceiba.tarifa.modelo.dto.DtoTarifa;
import com.ceiba.auto.modelo.dto.DtoAuto;



@Component
public class ManejadorCalculoRentaAuto implements ManejadorComandoRespuesta<ComandoCalculoRentaAuto, ComandoRespuesta<Double>> {

  
    private final ServicioCalcularRentaAuto servicioSolicitarRentarAuto;
    private final DaoAuto daoAuto;
    private final DaoTarifa daoTarifa;
    
    public ManejadorCalculoRentaAuto(ServicioCalcularRentaAuto servicioSolicitarRentarAuto, 
    									DaoAuto daoAuto,
    									DaoTarifa daoTarifa) {

        this.servicioSolicitarRentarAuto = servicioSolicitarRentarAuto;
        this.daoAuto = daoAuto;
        this.daoTarifa = daoTarifa;
    }

    
    public ComandoRespuesta<Double> ejecutar(ComandoCalculoRentaAuto comandoSolicitarRentaAuto) {
    	
    	DtoAuto auto = this.daoAuto.obtenerAutoPorPlaca(comandoSolicitarRentaAuto.getPlaca());
    	
    	System.out.println("este es el tipo de combustible"+auto.getTipoCombustible());
    	DtoTarifa tarifa = this.daoTarifa.obtenerTarifaPorTipoCombustible(auto.getTipoCombustible());
    	
    	BigDecimal porcentaje = tarifa.getPorcentaje();
    	
    	LocalDate fechaRenta = comandoSolicitarRentaAuto.getFechaRenta();
    	LocalDate fechaEntrega = comandoSolicitarRentaAuto.getFechaEntrega();
    	 
    	
    	return new ComandoRespuesta<>(this.servicioSolicitarRentarAuto.ejecutar(auto, porcentaje, fechaRenta, fechaEntrega)); 

    	

        
    }


}
