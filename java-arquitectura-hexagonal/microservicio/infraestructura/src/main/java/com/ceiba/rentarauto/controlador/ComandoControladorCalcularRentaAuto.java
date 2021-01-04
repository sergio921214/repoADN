package com.ceiba.rentarauto.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.rentarauto.comando.manejador.ManejadorCalculoRentaAuto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/rentauto")
@Api(tags = { "Controlador comando solicitar renta auto" })
public class ComandoControladorCalcularRentaAuto {

	private final ManejadorCalculoRentaAuto manejadorCalculoRentaAuto;

	@Autowired
	public ComandoControladorCalcularRentaAuto(ManejadorCalculoRentaAuto manejadorCalculoRentaAuto) {
		this.manejadorCalculoRentaAuto = manejadorCalculoRentaAuto;

	}

	@GetMapping("/totalrenta/{placa}/{fecharenta}/{fechaentrega}")

	@ApiOperation("Calcular valor total de renta auto")
	public ComandoRespuesta<Double> crear(@PathVariable("placa") String placa,
			@PathVariable("fecharenta") String fechaRenta, @PathVariable("fechaentrega") String fechaEntrega) {

		return this.manejadorCalculoRentaAuto.ejecutar(placa, fechaRenta, fechaEntrega);
	}

}