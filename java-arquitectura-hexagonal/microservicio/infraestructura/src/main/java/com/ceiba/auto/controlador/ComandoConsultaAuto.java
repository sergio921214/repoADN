package com.ceiba.auto.controlador;

import java.util.List;

import com.ceiba.auto.consulta.ManejadorListarAutos;
import com.ceiba.auto.consulta.ManejadorListarAutosDisponibles;
import com.ceiba.auto.consulta.ManejadorListarAutosRentados;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.auto.modelo.dto.DtoAuto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/auto")
@Api(tags={"Controlador consulta auto"})
public class ComandoConsultaAuto {

    private final ManejadorListarAutos manejadorListarAutos;
    private final ManejadorListarAutosDisponibles manejadorListarAutosDisponibles;
    private final ManejadorListarAutosRentados manejadorListarAutosRentados;

    public ComandoConsultaAuto(ManejadorListarAutos manejadorListarAutos,
    							ManejadorListarAutosDisponibles manejadorListarAutosDisponibles,
    							ManejadorListarAutosRentados manejadorListarAutosRentados) {
        this.manejadorListarAutos = manejadorListarAutos;
        this.manejadorListarAutosDisponibles = manejadorListarAutosDisponibles;
        this.manejadorListarAutosRentados = manejadorListarAutosRentados;
    }

    @GetMapping("/autos")
    @ApiOperation("Listar Autos")
    public List<DtoAuto> listar() {
        return this.manejadorListarAutos.ejecutar();
    }

    @GetMapping("/autos-disponibles")
    @ApiOperation("Listar Autos Disponibles")
    public List<DtoAuto> listarDisponibles() {
        return this.manejadorListarAutosDisponibles.ejecutar();
    }
    
    @GetMapping("/autos-rentados")
    @ApiOperation("Listar Autos Rentados")
    public List<DtoAuto> listarRentados() {
        return this.manejadorListarAutosRentados.ejecutar();
    }
}