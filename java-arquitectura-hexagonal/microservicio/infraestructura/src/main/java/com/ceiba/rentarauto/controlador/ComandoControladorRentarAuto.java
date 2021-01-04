package com.ceiba.rentarauto.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.rentarauto.comando.ComandoRentarAuto;
import com.ceiba.rentarauto.comando.manejador.ManejadorCrearRentarAuto;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/rentauto")
@Api(tags = { "Controlador comando rentar auto"})
public class ComandoControladorRentarAuto {

    private final ManejadorCrearRentarAuto manejadorCrearRentarAuto;
	
    @Autowired
    public ComandoControladorRentarAuto(ManejadorCrearRentarAuto manejadorCrearRentarAuto) {
        this.manejadorCrearRentarAuto = manejadorCrearRentarAuto;
		
		
    }

    @PostMapping
    @ApiOperation("Crear renta de  Auto")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoRentarAuto comandoRentarAuto) {
    	
        return manejadorCrearRentarAuto.ejecutar(comandoRentarAuto);
    }


}