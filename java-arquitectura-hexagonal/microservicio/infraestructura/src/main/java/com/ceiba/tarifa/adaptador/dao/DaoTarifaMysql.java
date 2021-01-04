package com.ceiba.tarifa.adaptador.dao;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;

import com.ceiba.tarifa.puerto.dao.DaoTarifa;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

@Component
public class DaoTarifaMysql implements DaoTarifa {

	private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

	@SqlStatement(namespace = "tarifa", value = "obtenerTarifaPorTipoCombustible")
	private static String sqlObtenerTarifaPorTipoCombustible;

	public DaoTarifaMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
		this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
	}

	@Override
	public Double obtenerTarifaPorTipoCombustible(String tipoCombustible) {

		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue("tipoCombustible", tipoCombustible);
		return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate()
				.queryForObject(sqlObtenerTarifaPorTipoCombustible, paramSource, Double.class);
	}
}
