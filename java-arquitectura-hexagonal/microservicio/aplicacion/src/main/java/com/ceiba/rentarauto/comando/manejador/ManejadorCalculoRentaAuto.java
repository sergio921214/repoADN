package com.ceiba.rentarauto.comando.manejador;

import com.ceiba.rentarauto.servicio.ServicioCalcularRentaAuto;

import org.springframework.stereotype.Component;

import com.ceiba.ComandoRespuesta;

import com.ceiba.auto.puerto.dao.DaoAuto;
import com.ceiba.tarifa.puerto.dao.DaoTarifa;
import com.ceiba.auto.modelo.dto.DtoAuto;

@Component
public class ManejadorCalculoRentaAuto {

	private final ServicioCalcularRentaAuto servicioCalcularRentaAuto;
	private final DaoAuto daoAuto;
	private final DaoTarifa daoTarifa;

	public ManejadorCalculoRentaAuto(ServicioCalcularRentaAuto servicioCalcularRentaAuto, DaoAuto daoAuto,
			DaoTarifa daoTarifa) {

		this.servicioCalcularRentaAuto = servicioCalcularRentaAuto;
		this.daoAuto = daoAuto;
		this.daoTarifa = daoTarifa;
	}

	public ComandoRespuesta<Double> ejecutar(String placa, String fechaRenta, String fechaEntrega) {

		DtoAuto auto = this.daoAuto.obtenerAutoPorPlaca(placa);
		Double porcentaje = this.daoTarifa.obtenerTarifaPorTipoCombustible(auto.getTipoCombustible());
		return new ComandoRespuesta<>(
				this.servicioCalcularRentaAuto.ejecutar(auto, porcentaje, fechaRenta, fechaEntrega));

	}

}
