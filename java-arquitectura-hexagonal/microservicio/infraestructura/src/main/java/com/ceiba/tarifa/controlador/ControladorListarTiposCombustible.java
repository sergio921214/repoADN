package com.ceiba.tarifa.controlador;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.tarifa.consulta.ManejadorListarTiposCombustible;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/tipo-combustible")
@Api(tags = { "Controlador consulta tipo combustible" })
public class ControladorListarTiposCombustible {

	private final ManejadorListarTiposCombustible manejadorListarTiposCombustible;

	public ControladorListarTiposCombustible(ManejadorListarTiposCombustible manejadorListarTiposCombustible) {
		this.manejadorListarTiposCombustible = manejadorListarTiposCombustible;
	}

	@GetMapping()
	@ApiOperation("Listar tipo de combustible")
	public List<String> listar() {
		return this.manejadorListarTiposCombustible.ejecutar();
	}

}