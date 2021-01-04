package com.ceiba.rentarauto.controlador;

import java.util.List;

import com.ceiba.rentarauto.consulta.ManejadorListarRentarAuto;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.rentarauto.modelo.dto.DtoRentarAuto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/rentauto")
@Api(tags = { "Controlador consulta renta de auto" })
public class ConsultaControladorRentarAuto {

	private final ManejadorListarRentarAuto manejadorListarRentarAuto;

	public ConsultaControladorRentarAuto(ManejadorListarRentarAuto manejadorListarRentarAuto) {
		this.manejadorListarRentarAuto = manejadorListarRentarAuto;

	}

	@GetMapping("/listarentautos")
	@ApiOperation("Listar rentas de Autos")
	public List<DtoRentarAuto> listar() {
		return this.manejadorListarRentarAuto.ejecutar();
	}

}
