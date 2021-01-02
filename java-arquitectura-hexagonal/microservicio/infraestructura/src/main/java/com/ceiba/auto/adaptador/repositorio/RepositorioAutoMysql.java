package com.ceiba.auto.adaptador.repositorio;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.auto.modelo.entidad.Auto;
import com.ceiba.auto.puerto.repositorio.RepositorioAuto;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioAutoMysql implements RepositorioAuto {
	private static final String PLACA = "placa";

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="auto", value="crear")
    private static String sqlCrear;

    @SqlStatement(namespace="auto", value="cambiarEstadoRentado")
    private static String sqlCambiarEstadoRentado;

    @SqlStatement(namespace="auto", value="existe")
    private static String sqlExiste;

    public RepositorioAutoMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public Long crear(Auto auto) {
        return this.customNamedParameterJdbcTemplate.crear(auto, sqlCrear);
    }

    @Override
    public boolean existe(String placa) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue(PLACA, placa);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExiste,paramSource, Boolean.class);
    }

    @Override
    public void rentar(String placa) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue(PLACA, placa);
        this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlCambiarEstadoRentado,paramSource);
    }


}

