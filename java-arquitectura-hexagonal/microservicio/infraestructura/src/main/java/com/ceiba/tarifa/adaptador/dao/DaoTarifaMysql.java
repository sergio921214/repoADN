package com.ceiba.tarifa.adaptador.dao;

import java.util.List;


import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;

import com.ceiba.tarifa.puerto.dao.DaoTarifa;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

import com.ceiba.tarifa.modelo.dto.DtoTarifa;

@Component
public class DaoTarifaMysql implements DaoTarifa {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="tarifa", value="listar")
    private static String sqlListar;
    
    @SqlStatement(namespace="tarifa", value="obtenerTarifaPorTipoCombustible")
    private static String sqlObtenerTarifaPorTipoCombustible;
    

    
    public DaoTarifaMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public List<DtoTarifa> listar() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListar, new MapeoTarifa());
    }
  

	@Override
	public DtoTarifa obtenerTarifaPorTipoCombustible(String tipoCombustible) {
		System.out.println("este es el tipo de combustible de obtener tarifa" + tipoCombustible);
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("tipoCombustible", tipoCombustible);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlObtenerTarifaPorTipoCombustible,paramSource, new MapeoTarifa());
	}
}
