package com.ceiba.rentarauto.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.rentarauto.comando.ComandoCalculoRentaAuto;
import com.ceiba.rentarauto.comando.manejador.ManejadorSolicitarRentaAuto;

//import com.ceiba.rentarauto.modelo.entidad.SolicitudRentarAuto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/auto")
@Api(tags = { "Controlador comando solicitar renta auto"})
public class ComandoControladorSolicitarRentaAuto {

    private final ManejadorSolicitarRentaAuto manejadorSolicitarRentaAuto;
	


    @Autowired
    public ComandoControladorSolicitarRentaAuto(ManejadorSolicitarRentaAuto manejadorSolicitarRentaAuto) {
        this.manejadorSolicitarRentaAuto = manejadorSolicitarRentaAuto;
		
		
    }

    @PostMapping("/calculoRenta")
    @ApiOperation("Calcular valor total de renta auto")
    public ComandoRespuesta<Double ,Integer, String > crear(@RequestBody ComandoCalculoRentaAuto comandoSolicitarRentaAuto) {
        return manejadorSolicitarRentaAuto.ejecutar(comandoSolicitarRentaAuto);
    }



}