package com.ceiba.tarifa.puerto.dao;


public interface DaoTarifa {

	/**
	 * Permite obtener una tarifa por tipoCombustible
	 * 
	 * @return tarifa por tipoCombustible
	 */
	Double obtenerTarifaPorTipoCombustible(String tipoCombustible);

}
