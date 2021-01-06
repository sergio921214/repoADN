package com.ceiba.auto.controlador;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

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
import com.ceiba.auto.modelo.dto.DtoAuto;
import com.ceiba.auto.puerto.dao.DaoAuto;
import com.ceiba.auto.servicio.testdatabuilder.ComandoAutoTestDataBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = ApplicationMock.class)
@WebMvcTest(ComandoControladorAuto.class)
public class ComandoControladorAutoTest {

	@Autowired
	private ObjectMapper objectMapper;
	@Autowired
	private DaoAuto daoAuto;

	@Autowired
	private MockMvc mocMvc;

	@Test
	public void crear() throws Exception {
		// arrange
		ComandoAuto auto = new ComandoAutoTestDataBuilder().build();
		DtoAuto autoConsulta = new DtoAuto("ABC123","GASOLINA",50000.0,3.0);
		
		mocMvc.perform(
				post("/auto").contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(auto)));
				//.andExpect(status().isOk()).andExpect(content().json("{'valor': 3}"));
		// act - assert
		assertEquals(autoConsulta.getTipoCombustible(), daoAuto.obtenerAutoPorPlaca("ABC123").getTipoCombustible());
	}

}
