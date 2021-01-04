package com.ceiba.tarifa.consulta;

import java.util.List;

import org.springframework.stereotype.Component;

import com.ceiba.tarifa.puerto.dao.DaoTipoCombustible;

@Component
public class ManejadorListarTiposCombustible {

	private final DaoTipoCombustible daoTipoCombustible;

	public ManejadorListarTiposCombustible(DaoTipoCombustible daoTipoCombustible) {
		this.daoTipoCombustible = daoTipoCombustible;
	}

	public List<String> ejecutar() {
		return this.daoTipoCombustible.listar();

	}

}
