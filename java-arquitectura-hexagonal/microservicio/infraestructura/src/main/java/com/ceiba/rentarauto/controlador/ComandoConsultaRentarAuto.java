package com.ceiba.rentarauto.controlador;

import java.util.List;

import com.ceiba.rentarauto.consulta.ManejadorListarRentarAuto;
import com.ceiba.rentarauto.consulta.ManejadorObtenerRentarAutoPorPlaca;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.rentarauto.modelo.dto.DtoRentarAuto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/rentauto")
@Api(tags={"Controlador consulta renta de auto"})
public class ComandoConsultaRentarAuto {

    private final ManejadorListarRentarAuto manejadorListarRentarAuto;
    private final ManejadorObtenerRentarAutoPorPlaca manejadorObtenerRentarAutoPorPlaca;
   

    public ComandoConsultaRentarAuto(ManejadorListarRentarAuto manejadorListarRentarAuto,
    								ManejadorObtenerRentarAutoPorPlaca manejadorObtenerRentarAutoPorPlaca
    							) {
        this.manejadorListarRentarAuto = manejadorListarRentarAuto;
        this.manejadorObtenerRentarAutoPorPlaca = manejadorObtenerRentarAutoPorPlaca;
        
    }

    @GetMapping("/listarentautos")
    @ApiOperation("Listar rentas de Autos")
    public List<DtoRentarAuto> listar() {
        return this.manejadorListarRentarAuto.ejecutar();
    }

    @GetMapping("/listarentautosporplaca/{placa}")
    @ApiOperation("Listar Autos Disponibles")
    public DtoRentarAuto obtenerRentarAutoPorPlaca(@PathVariable("placa") String placa) {
        return this.manejadorObtenerRentarAutoPorPlaca.ejecutar(placa);
    }

}
