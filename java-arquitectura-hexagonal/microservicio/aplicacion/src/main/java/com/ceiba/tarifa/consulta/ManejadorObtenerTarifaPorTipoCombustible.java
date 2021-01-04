package com.ceiba.tarifa.consulta;

import org.springframework.stereotype.Component;

import com.ceiba.tarifa.puerto.dao.DaoTarifa;

@Component
public class ManejadorObtenerTarifaPorTipoCombustible {

	private final DaoTarifa daoTarifa;

	public ManejadorObtenerTarifaPorTipoCombustible(DaoTarifa daoTarifa) {
		this.daoTarifa = daoTarifa;
	}

	public Double ejecutar(String tipoCombustible) {
		return this.daoTarifa.obtenerTarifaPorTipoCombustible(tipoCombustible);
	}

}