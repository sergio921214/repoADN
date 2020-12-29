package com.ceiba.tarifa.adaptador.dao;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;


import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.tarifa.modelo.dto.DtoTarifa;
import org.springframework.jdbc.core.RowMapper;

public class MapeoTarifa implements RowMapper<DtoTarifa>, MapperResult {

    @Override
    public DtoTarifa mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        Long id = resultSet.getLong("id");
        String tipoCombustible = resultSet.getString("tipoCombustible");
        BigDecimal porcentaje = resultSet.getBigDecimal("multiplicadorFinSemana");

        return new DtoTarifa(id,tipoCombustible,porcentaje);
    }

}