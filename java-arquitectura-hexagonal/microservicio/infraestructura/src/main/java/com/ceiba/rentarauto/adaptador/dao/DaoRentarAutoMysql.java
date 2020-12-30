package com.ceiba.rentarauto.adaptador.dao;

import java.util.List;


import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.rentarauto.puerto.dao.DaoRentarAuto;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

import com.ceiba.rentarauto.modelo.dto.DtoRentarAuto;

@Component
public class DaoRentarAutoMysql implements DaoRentarAuto {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="rentarauto", value="listar")
    private static String sqlListar;
    
    @SqlStatement(namespace = "rentarauto", value = "obtenerRentarAutoPorPlaca")
    private static String sqlObtenerRentarAutoPorPlaca;

    public DaoRentarAutoMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public List<DtoRentarAuto> listar() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListar, new MapeoRentarAuto());
    }

	@Override
	public DtoRentarAuto obtenerRentaPorPlaca(String placa) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("placa", placa);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlObtenerRentarAutoPorPlaca,paramSource, new MapeoRentarAuto());
	}
}
