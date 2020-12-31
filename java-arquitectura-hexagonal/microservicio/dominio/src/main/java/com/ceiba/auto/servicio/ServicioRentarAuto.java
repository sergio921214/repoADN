package com.ceiba.auto.servicio;

import com.ceiba.auto.puerto.repositorio.RepositorioAuto;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;

public class ServicioRentarAuto {

	private static final String EL_AUTO_NO_EXISTE_EN_EL_SISTEMA = "El auto NO existe en el sistema";
	private final RepositorioAuto repositorioAuto;

	public ServicioRentarAuto(RepositorioAuto repositorioAuto) {
		this.repositorioAuto = repositorioAuto;
	}

	public void ejecutar(String placa) {
		validarExistenciaPrevia(placa);
		this.repositorioAuto.rentar(placa);
	}

	private void validarExistenciaPrevia(String placa) {
		boolean existe = this.repositorioAuto.existe(placa);
		if (!existe) {
			throw new ExcepcionValorInvalido(EL_AUTO_NO_EXISTE_EN_EL_SISTEMA);
		}

	}

}
