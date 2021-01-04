package com.ceiba.auto.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.auto.comando.ComandoAuto;
import com.ceiba.auto.comando.manejador.ManejadorCrearAuto;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/auto")
@Api(tags = { "Controlador comando auto" })
public class ComandoControladorAuto {

	private final ManejadorCrearAuto manejadorCrearAuto;
	

	@Autowired
	public ComandoControladorAuto(ManejadorCrearAuto manejadorCrearAuto) {
		this.manejadorCrearAuto = manejadorCrearAuto;

	}

	@PostMapping
	@ApiOperation("Crear Auto")
	public ComandoRespuesta<Long> crear(@RequestBody ComandoAuto comandoAuto) {
		return manejadorCrearAuto.ejecutar(comandoAuto);
	}

}