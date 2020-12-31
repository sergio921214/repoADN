package com.ceiba.rentarauto.servicio;

import com.ceiba.auto.puerto.repositorio.RepositorioAuto;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.rentarauto.modelo.entidad.RentarAuto;
import com.ceiba.rentarauto.puerto.repositorio.RepositorioRentarAuto;

public class ServicioGuardarRentaAuto {

	private static final String LA_RENTA_YA_EXISTE_EN_EL_SISTEMA = "La renta ya existe en el sistema";

	private final RepositorioRentarAuto repositorioRentarAuto;
	private final RepositorioAuto repositorioAuto;

	public ServicioGuardarRentaAuto(RepositorioRentarAuto repositorioRentarAuto, RepositorioAuto repositorioAuto) {

		this.repositorioRentarAuto = repositorioRentarAuto;
		this.repositorioAuto = repositorioAuto;

	}

	public Long ejecutar(RentarAuto rentarAuto) {
		validarExistenciaPrevia(rentarAuto);

		this.repositorioAuto.rentar(rentarAuto.getPlaca());
		return this.repositorioRentarAuto.guardarRenta(rentarAuto);
	}

	private void validarExistenciaPrevia(RentarAuto rentarAuto) {
		boolean existe = this.repositorioRentarAuto.existe(rentarAuto.getPlaca());
		if (existe) {
			throw new ExcepcionDuplicidad(LA_RENTA_YA_EXISTE_EN_EL_SISTEMA);
		}
	}

}