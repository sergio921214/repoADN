package com.ceiba.auto.controlador;

import java.util.List;

import com.ceiba.auto.consulta.ManejadorListarAutos;
import com.ceiba.auto.consulta.ManejadorListarAutosDisponibles;
import com.ceiba.auto.consulta.ManejadorListarAutosRentados;
import com.ceiba.auto.consulta.ManejadorListarPlacasDisponibles;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.auto.modelo.dto.DtoAuto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/autos")
@Api(tags = { "Controlador consulta auto" })
public class ConsultaControladorAuto {

	private final ManejadorListarAutos manejadorListarAutos;
	private final ManejadorListarAutosDisponibles manejadorListarAutosDisponibles;
	private final ManejadorListarAutosRentados manejadorListarAutosRentados;
	private final ManejadorListarPlacasDisponibles manejadorListarPlacasDisponibles;

	public ConsultaControladorAuto(ManejadorListarAutos manejadorListarAutos,
			ManejadorListarAutosDisponibles manejadorListarAutosDisponibles,
			ManejadorListarAutosRentados manejadorListarAutosRentados,
			ManejadorListarPlacasDisponibles manejadorListarPlacasDisponibles) {
		this.manejadorListarAutos = manejadorListarAutos;
		this.manejadorListarAutosDisponibles = manejadorListarAutosDisponibles;
		this.manejadorListarAutosRentados = manejadorListarAutosRentados;
		this.manejadorListarPlacasDisponibles=manejadorListarPlacasDisponibles;
	}

	@GetMapping()
	@ApiOperation("Listar Autos")
	public List<DtoAuto> listar() {
		return this.manejadorListarAutos.ejecutar();
	}

	@GetMapping("/disponibles")
	@ApiOperation("Listar Autos Disponibles")
	public List<DtoAuto> listarDisponibles() {
		return this.manejadorListarAutosDisponibles.ejecutar();
	}

	@GetMapping("/rentados")
	@ApiOperation("Listar Autos Rentados")
	public List<DtoAuto> listarRentados() {
		return this.manejadorListarAutosRentados.ejecutar();
	}
	
	@GetMapping("/placasdisponibles")
	@ApiOperation("Listar placas de auto disponibles")
	public List<String> listarPlacaDisponibles() {
		return this.manejadorListarPlacasDisponibles.ejecutar();
	}
}