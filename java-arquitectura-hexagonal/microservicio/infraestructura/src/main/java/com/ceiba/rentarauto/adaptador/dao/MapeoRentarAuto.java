package com.ceiba.rentarauto.adaptador.dao;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.rentarauto.modelo.dto.DtoRentarAuto;
import org.springframework.jdbc.core.RowMapper;

public class MapeoRentarAuto implements RowMapper<DtoRentarAuto>, MapperResult {

    @Override
    public DtoRentarAuto mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        Long id = resultSet.getLong("id");
        String placa = resultSet.getString("placa");
        LocalDate fechaRenta = extraerLocalDate(resultSet, "fechaRenta");
        LocalDate fechaEntrega = extraerLocalDate(resultSet, "fechaEntrega");
        Double precioRenta = resultSet.getDouble("precioTotalRenta");
        

        return new DtoRentarAuto(id,placa,fechaRenta,fechaEntrega, precioRenta);
    }

}