package com.ceiba.rentarauto.comando.manejador;


import com.ceiba.manejador.ManejadorComando;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import com.ceiba.rentarauto.comando.ComandoSolicitarRentaAuto;
import com.ceiba.rentarauto.modelo.entidad.SolicitudRentarAuto;
import com.ceiba.rentarauto.servicio.ServicioSolicitarRentarAuto;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.stereotype.Component;

import com.ceiba.ComandoRespuesta;

import com.ceiba.auto.consulta.ManejadorObtenerAutoPorPlaca;
import com.ceiba.tarifa.consulta.ManejadorObtenerTarifaPorTipoCombustible;
import com.ceiba.tarifa.modelo.dto.DtoTarifa;
import com.ceiba.auto.modelo.dto.DtoAuto;
//import com.ceiba.dominio.excepcion.ExcepcionDomingo;
import com.ceiba.dominio.excepcion.ExcepcionDomingo;

@Component
public class ManejadorSolicitarRentaAuto implements ManejadorComandoRespuesta<ComandoSolicitarRentaAuto, ComandoRespuesta<Double, Integer, String >> {

  
    private final ServicioSolicitarRentarAuto servicioSolicitarRentarAuto;
    private final ManejadorObtenerAutoPorPlaca manejadorObtenerAutoPorPlaca;
    private final ManejadorObtenerTarifaPorTipoCombustible manejadorObtenerTarifaPorTipoCombustible;
    
    public ManejadorSolicitarRentaAuto(ServicioSolicitarRentarAuto servicioSolicitarRentarAuto, 
    									ManejadorObtenerAutoPorPlaca manejadorObtenerAutoPorPlaca,
    									ManejadorObtenerTarifaPorTipoCombustible manejadorObtenerTarifaPorTipoCombustible) {

        this.servicioSolicitarRentarAuto = servicioSolicitarRentarAuto;
        this.manejadorObtenerAutoPorPlaca = manejadorObtenerAutoPorPlaca;
        this.manejadorObtenerTarifaPorTipoCombustible = manejadorObtenerTarifaPorTipoCombustible;
    }

    public ComandoRespuesta<Double, Integer, String > ejecutar(ComandoSolicitarRentaAuto comandoSolicitarRentaAuto) {
    	//DtoAuto auto = this.manejadorObtenerAutoPorPlaca.ejecutar(comandoSolicitarRentaAuto.getPlaca());
    	//System.out.println("el auto es "+auto.getTipoCombustible());
    	DtoTarifa tarifa = this.manejadorObtenerTarifaPorTipoCombustible.ejecutar("GAS");
    	System.out.println("la tarifa es : "+tarifa);
    	//BigDecimal porcentaje = tarifa.getPorcentaje();
    	BigDecimal porcentaje = new BigDecimal(1.2);
    	LocalDate fechaRenta = comandoSolicitarRentaAuto.getFechaRenta();
    	LocalDate fechaEntrega = comandoSolicitarRentaAuto.getFechaEntrega();
    	Double precioTotalRenta; 
    	
    	try {
    		precioTotalRenta = this.servicioSolicitarRentarAuto.ejecutar(null, porcentaje, fechaRenta, fechaEntrega ); 
    		System.out.println(" NO hubo una excepcion ");
    	}catch(ExcepcionDomingo e){
    		System.out.println("hubo una excepcion ");
    		 return new ComandoRespuesta<>(null, -1, e.getMessage());   
    	}
    	
        return new ComandoRespuesta<>(precioTotalRenta, 0, "succes"); 
        
    }


}
