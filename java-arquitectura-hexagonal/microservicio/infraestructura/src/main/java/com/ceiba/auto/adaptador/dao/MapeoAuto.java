package com.ceiba.auto.adaptador.dao;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;


import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.auto.modelo.dto.DtoAuto;
import org.springframework.jdbc.core.RowMapper;

public class MapeoAuto implements RowMapper<DtoAuto>, MapperResult {

    @Override
    public DtoAuto mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        Long id = resultSet.getLong("id");
        String placa = resultSet.getString("placa");
        String tipoCombustible = resultSet.getString("tipoCombustible");
        Boolean rentado = resultSet.getBoolean("rentado");
        Double precioPorDia = resultSet.getDouble("precioPorDia");
        BigDecimal multiplicadorFinSemana = resultSet.getBigDecimal("multiplicadorFinSemana");

        return new DtoAuto(id,placa,tipoCombustible,rentado, precioPorDia, multiplicadorFinSemana);
    }

}