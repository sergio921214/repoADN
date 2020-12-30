package com.ceiba.auto.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.auto.comando.ComandoAuto;
import com.ceiba.auto.comando.manejador.ManejadorCrearAuto;
import com.ceiba.auto.comando.manejador.ManejadorRentarAuto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/auto")
@Api(tags = { "Controlador comando auto"})
public class ComandoControladorAuto {

    private final ManejadorCrearAuto manejadorCrearAuto;
	private final ManejadorRentarAuto manejadorRentarAuto;


    @Autowired
    public ComandoControladorAuto(ManejadorCrearAuto manejadorCrearAuto,
    								ManejadorRentarAuto manejadorRentarAuto) {
        this.manejadorCrearAuto = manejadorCrearAuto;
		this.manejadorRentarAuto = manejadorRentarAuto;
		
    }

    @PostMapping
    @ApiOperation("Crear Auto")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoAuto comandoAuto) {
        return manejadorCrearAuto.ejecutar(comandoAuto);
    }


	@PutMapping(value="/{placa}")
	@ApiOperation("rentar auto")
	public void actualizar(@PathVariable String placa) {
		
		manejadorRentarAuto.ejecutar(placa);
	}
}