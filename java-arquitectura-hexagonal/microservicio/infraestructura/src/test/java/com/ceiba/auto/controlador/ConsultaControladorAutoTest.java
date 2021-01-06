package com.ceiba.auto.controlador;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.ceiba.ApplicationMock;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes= ApplicationMock.class)
@WebMvcTest(ConsultaControladorAuto.class)
public class ConsultaControladorAutoTest {
	
    @Autowired
    private MockMvc mocMvc;

    @Test
    public void listar() throws Exception {
        // arrange

        // act - assert
        mocMvc.perform(get("/autos")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].placa", is("BZA485")));
    }
    
    @Test
    public void listarDisponibles() throws Exception {
        // arrange

        // act - assert
        mocMvc.perform(get("/autos/disponibles")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())                
                .andExpect(jsonPath("$[0].placa", is("BZA485")));
    }
    
    @Test
    public void listarRentados() throws Exception {
        // arrange

        // act - assert
        mocMvc.perform(get("/autos/rentados")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].placa", is("BZA486")));
    }

}
