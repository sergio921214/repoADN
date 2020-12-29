package com.ceiba.rentarauto.comando.manejador;


import com.ceiba.manejador.ManejadorComando;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import com.ceiba.rentarauto.comando.ComandoCalculoRentaAuto;
import com.ceiba.rentarauto.modelo.entidad.CalculoRentaAuto;
import com.ceiba.rentarauto.servicio.ServicioCalcularRentaAuto;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.stereotype.Component;

import com.ceiba.ComandoRespuesta;

import com.ceiba.auto.puerto.dao.DaoAuto;
import com.ceiba.tarifa.puerto.dao.DaoTarifa;
import com.ceiba.tarifa.modelo.dto.DtoTarifa;
import com.ceiba.auto.modelo.dto.DtoAuto;
//import com.ceiba.dominio.excepcion.ExcepcionDomingo;
import com.ceiba.dominio.excepcion.ExcepcionDomingo;

@Component
public class ManejadorSolicitarRentaAuto implements ManejadorComandoRespuesta<ComandoCalculoRentaAuto, ComandoRespuesta<Double, Integer, String >> {

  
    private final ServicioCalcularRentaAuto servicioSolicitarRentarAuto;
    private final DaoAuto daoAuto;
    private final DaoTarifa daoTarifa;
    
    public ManejadorSolicitarRentaAuto(ServicioCalcularRentaAuto servicioSolicitarRentarAuto, 
    									DaoAuto daoAuto,
    									DaoTarifa daoTarifa) {

        this.servicioSolicitarRentarAuto = servicioSolicitarRentarAuto;
        this.daoAuto = daoAuto;
        this.daoTarifa = daoTarifa;
    }

    public ComandoRespuesta<Double, Integer, String > ejecutar(ComandoCalculoRentaAuto comandoSolicitarRentaAuto) {
    	DtoAuto auto = this.daoAuto.obtenerAutoPorPlaca(comandoSolicitarRentaAuto.getPlaca());
    	
    	DtoTarifa tarifa = this.daoTarifa.obtenerTarifaPorTipoCombustible(auto.getTipoCombustible());
    	
    	BigDecimal porcentaje = tarifa.getPorcentaje();
    	
    	LocalDate fechaRenta = comandoSolicitarRentaAuto.getFechaRenta();
    	LocalDate fechaEntrega = comandoSolicitarRentaAuto.getFechaEntrega();
    	Double precioTotalRenta; 
    	
    	try {
    		precioTotalRenta = this.servicioSolicitarRentarAuto.ejecutar(auto, porcentaje, fechaRenta, fechaEntrega ); 
    		System.out.println(" NO hubo una excepcion ");
    	}catch(ExcepcionDomingo e){
    		System.out.println("hubo una excepcion ");
    		 return new ComandoRespuesta<>(null, -1, e.getMessage());   
    	}
    	
        return new ComandoRespuesta<>(precioTotalRenta, 0, "succes"); 
        
    }


}
