package com.ceiba.rentarauto.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.rentarauto.comando.ComandoCalculoRentaAuto;
import com.ceiba.rentarauto.comando.manejador.ManejadorCalculoRentaAuto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/auto")
@Api(tags = { "Controlador comando solicitar renta auto"})
public class ComandoControladorSolicitarRentaAuto {

    private final ManejadorCalculoRentaAuto manejadorCalculoRentaAuto;
	


    @Autowired
    public ComandoControladorSolicitarRentaAuto(ManejadorCalculoRentaAuto manejadorCalculoRentaAuto) {
        this.manejadorCalculoRentaAuto = manejadorCalculoRentaAuto;
		
		
    }

    @PostMapping("/calculoRenta")
    @ApiOperation("Calcular valor total de renta auto")
    public ComandoRespuesta<Double> crear(@RequestBody ComandoCalculoRentaAuto comandoCalculoRentaAuto) {
        return manejadorCalculoRentaAuto.ejecutar(comandoCalculoRentaAuto);
    }



}