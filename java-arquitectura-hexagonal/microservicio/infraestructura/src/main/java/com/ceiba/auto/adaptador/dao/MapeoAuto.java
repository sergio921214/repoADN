package com.ceiba.auto.adaptador.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.auto.modelo.dto.DtoAuto;
import org.springframework.jdbc.core.RowMapper;

public class MapeoAuto implements RowMapper<DtoAuto>, MapperResult {

	@Override
	public DtoAuto mapRow(ResultSet resultSet, int rowNum) throws SQLException {

		String placa = resultSet.getString("placa");
		String tipoCombustible = resultSet.getString("tipoCombustible");
		Double precioPorDia = resultSet.getDouble("precioPorDia");
		Double multiplicadorFinSemana = resultSet.getDouble("multiplicadorFinSemana");

		return new DtoAuto( placa, tipoCombustible, precioPorDia, multiplicadorFinSemana);
	}

}