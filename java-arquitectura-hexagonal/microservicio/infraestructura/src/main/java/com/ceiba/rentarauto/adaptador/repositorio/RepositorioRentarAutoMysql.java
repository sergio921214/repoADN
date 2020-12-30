package com.ceiba.rentarauto.adaptador.repositorio;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.rentarauto.modelo.entidad.RentarAuto;
import com.ceiba.rentarauto.puerto.repositorio.RepositorioRentarAuto;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioRentarAutoMysql implements RepositorioRentarAuto {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="rentarauto", value="crear")
    private static String sqlCrear;

    @SqlStatement(namespace="rentarauto", value="existe")
    private static String sqlExiste;

 

    public RepositorioRentarAutoMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public Long guardarRenta(RentarAuto rentarAuto) {
        return this.customNamedParameterJdbcTemplate.crear(rentarAuto, sqlCrear);
    }

    @Override
    public boolean existe(String placa) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("placa", placa);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExiste,paramSource, Boolean.class);
    }


}


