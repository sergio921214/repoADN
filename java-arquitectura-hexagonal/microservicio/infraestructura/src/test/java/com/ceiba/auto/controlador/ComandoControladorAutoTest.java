package com.ceiba.auto.controlador;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
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
import com.ceiba.auto.comando.ComandoAuto;
import com.ceiba.auto.servicio.testdatabuilder.ComandoAutoTestDataBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes= ApplicationMock.class)
@WebMvcTest(ComandoControladorAuto.class)
public class ComandoControladorAutoTest {
	
    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mocMvc;

    @Test
    public void crear() throws Exception{
        // arrange
        ComandoAuto auto = new ComandoAutoTestDataBuilder().build();

        // act - assert
        mocMvc.perform(post("/auto")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(auto)))
                .andExpect(status().isOk())
                .andExpect(content().json("{'valor': 2}"));
    }

	/*
	 * @Test public void actualizar() throws Exception{ // arrange Long id = 2L;
	 * ComandoUsuario usuario = new ComandoUsuarioTestDataBuilder().build();
	 * 
	 * // act - assert mocMvc.perform(put("/usuarios/{id}",id)
	 * .contentType(MediaType.APPLICATION_JSON)
	 * .content(objectMapper.writeValueAsString(usuario)))
	 * .andExpect(status().isOk()); }
	 * 
	 * @Test public void eliminar() throws Exception { // arrange Long id = 2L;
	 * 
	 * // act - assert mocMvc.perform(delete("/usuarios/{id}",id)
	 * .contentType(MediaType.APPLICATION_JSON) .accept(MediaType.APPLICATION_JSON))
	 * .andExpect(status().isOk()); }
	 */

}
