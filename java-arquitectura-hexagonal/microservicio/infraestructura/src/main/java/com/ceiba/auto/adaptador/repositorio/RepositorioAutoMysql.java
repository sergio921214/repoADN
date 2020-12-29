package com.ceiba.auto.adaptador.repositorio;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.auto.modelo.entidad.Auto;
import com.ceiba.auto.puerto.repositorio.RepositorioAuto;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioAutoMysql implements RepositorioAuto {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="auto", value="crear")
    private static String sqlCrear;

    @SqlStatement(namespace="auto", value="rentar")
    private static String sqlRentar;

    @SqlStatement(namespace="auto", value="existe")
    private static String sqlExiste;

    @SqlStatement(namespace="auto", value="existeExcluyendoId") 
    private static String sqlExisteExcluyendoId;

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
        paramSource.addValue("placa", placa);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExiste,paramSource, Boolean.class);
    }

    @Override
    public void rentar(Auto auto) {
        this.customNamedParameterJdbcTemplate.actualizar(auto, sqlRentar);
    }

    @Override
    public boolean existeExcluyendoId(Long id, String placa) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);
        paramSource.addValue("placa", placa);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExisteExcluyendoId,paramSource, Boolean.class);
    }
}

