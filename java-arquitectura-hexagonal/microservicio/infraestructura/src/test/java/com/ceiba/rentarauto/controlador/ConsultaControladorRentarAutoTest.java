package com.ceiba.rentarauto.controlador;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.ceiba.ApplicationMock;
import com.ceiba.rentarauto.modelo.dto.DtoRentarAuto;
import com.ceiba.rentarauto.puerto.dao.DaoRentarAuto;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes= ApplicationMock.class)
@WebMvcTest(ConsultaControladorRentarAuto.class)
public class ConsultaControladorRentarAutoTest {
	
    @Autowired
    private MockMvc mocMvc;
    @Autowired
    private DaoRentarAuto daoRentarAuto;

    @Test
    public void listar() throws Exception {
        // arrange
    	List <DtoRentarAuto> lista = daoRentarAuto.listar();
        // act - assert
        mocMvc.perform(get("/rentauto/listarentautos")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].placa", is(lista.get(0).getPlaca())));
    }
    

}
