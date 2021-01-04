package com.ceiba.rentarauto.puerto.dao;

import java.util.List;

import com.ceiba.rentarauto.modelo.dto.DtoRentarAuto;

public interface DaoRentarAuto {

	/**
	 * Permite listar las rentas de auto
	 * 
	 * @return las rentas de auto
	 */
	List<DtoRentarAuto> listar();

}
