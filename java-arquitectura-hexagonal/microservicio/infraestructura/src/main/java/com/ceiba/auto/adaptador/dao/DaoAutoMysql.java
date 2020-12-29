package com.ceiba.auto.adaptador.dao;

import java.util.List;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;

import com.ceiba.auto.puerto.dao.DaoAuto;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

import com.ceiba.auto.modelo.dto.DtoAuto;

@Component
public class DaoAutoMysql implements DaoAuto {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="auto", value="listar")
    private static String sqlListar;
    
    @SqlStatement(namespace="auto", value="listarDisponibles")
    private static String sqlListarDisponibles;
    
    @SqlStatement(namespace="auto", value="listarRentados")
    private static String sqlListarRentados;
    
    @SqlStatement(namespace="auto", value="obtenerAutoPorPlaca")
    private static String sqlObtenerAutoPorPlaca;
    
    public DaoAutoMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public List<DtoAuto> listar() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListar, new MapeoAuto());
    }
    @Override
    public List<DtoAuto> listarDisponibles() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListarDisponibles, new MapeoAuto());
    }
    @Override
    public List<DtoAuto> listarRentados() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListarRentados, new MapeoAuto());
    }

	@Override
	public DtoAuto obtenerAutoPorPlaca(String placa) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("placa", placa);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlObtenerAutoPorPlaca,paramSource, new MapeoAuto());
		
	}
}
