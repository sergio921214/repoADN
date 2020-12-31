package com.ceiba.rentarauto.comando.manejador;

import com.ceiba.manejador.ManejadorComandoRespuesta;
import com.ceiba.rentarauto.comando.ComandoCalculoRentaAuto;

import com.ceiba.rentarauto.servicio.ServicioCalcularRentaAuto;

import org.springframework.stereotype.Component;

import com.ceiba.ComandoRespuesta;

import com.ceiba.auto.puerto.dao.DaoAuto;
import com.ceiba.tarifa.puerto.dao.DaoTarifa;
import com.ceiba.tarifa.modelo.dto.DtoTarifa;
import com.ceiba.auto.modelo.dto.DtoAuto;

@Component
public class ManejadorCalculoRentaAuto
		implements ManejadorComandoRespuesta<ComandoCalculoRentaAuto, ComandoRespuesta<Double>> {

	private final ServicioCalcularRentaAuto servicioCalcularRentaAuto;
	private final DaoAuto daoAuto;
	private final DaoTarifa daoTarifa;

	public ManejadorCalculoRentaAuto(ServicioCalcularRentaAuto servicioCalcularRentaAuto, DaoAuto daoAuto,
			DaoTarifa daoTarifa) {

		this.servicioCalcularRentaAuto = servicioCalcularRentaAuto;
		this.daoAuto = daoAuto;
		this.daoTarifa = daoTarifa;
	}

	public ComandoRespuesta<Double> ejecutar(ComandoCalculoRentaAuto comandoCalculoRentaAuto) {

		DtoAuto auto = this.daoAuto.obtenerAutoPorPlaca(comandoCalculoRentaAuto.getPlaca());
		DtoTarifa tarifa = this.daoTarifa.obtenerTarifaPorTipoCombustible(auto.getTipoCombustible());
		Double porcentaje = tarifa.getPorcentaje();

		return new ComandoRespuesta<>(this.servicioCalcularRentaAuto.ejecutar(auto, porcentaje,
				comandoCalculoRentaAuto.getFechaRenta(), comandoCalculoRentaAuto.getFechaEntrega()));

	}

}
