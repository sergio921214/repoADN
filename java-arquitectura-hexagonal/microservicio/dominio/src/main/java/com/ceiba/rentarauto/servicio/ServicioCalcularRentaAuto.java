package com.ceiba.rentarauto.servicio;

import java.util.Date;

import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.dominio.utilidades.UtilidadesFecha;

import com.ceiba.auto.modelo.dto.DtoAuto;

import com.ceiba.auto.puerto.repositorio.RepositorioAuto;

public class ServicioCalcularRentaAuto {

	private final RepositorioAuto repositorioAuto;

	private static final String EL_AUTO_NO_EXISTE_EN_EL_SISTEMA = "El auto NO existe en el sistema";

	public ServicioCalcularRentaAuto(RepositorioAuto repositorioAuto) {
		this.repositorioAuto = repositorioAuto;
	}

	public Double ejecutar(DtoAuto auto, Double porcentaje, String fechaRenta, String fechaEntrega) {

		validarExistenciaPrevia(auto.getPlaca());
		Date fechaRentaDate = UtilidadesFecha.convertirStringADate(fechaRenta, "yyyy-MM-dd");
		Date fechaEntregaDate = UtilidadesFecha.convertirStringADate(fechaEntrega, "yyyy-MM-dd");
		Double precioPorDiaTarifaCombustible = porcentaje * auto.getPrecioPorDia();
		Double precioPorDiaFinSemana = precioPorDiaTarifaCombustible * auto.getMultiplicadorFinSemana();
		Integer diasFinSemana = UtilidadesFecha.contarDiasFinSemana(fechaRentaDate, fechaEntregaDate);
		Integer diasDeSemana = UtilidadesFecha.contarDiasDeSemana(fechaRentaDate, fechaEntregaDate);
		Double precioTotalFinSemana = precioPorDiaFinSemana * diasFinSemana;
		Double precioTotalDiasDeSemana = precioPorDiaTarifaCombustible * diasDeSemana;

		return precioTotalDiasDeSemana + precioTotalFinSemana;

	}

	private void validarExistenciaPrevia(String placa) {
		boolean existe = this.repositorioAuto.existe(placa);
		if (!existe) {
			throw new ExcepcionValorInvalido(EL_AUTO_NO_EXISTE_EN_EL_SISTEMA);
		}
	}

}
