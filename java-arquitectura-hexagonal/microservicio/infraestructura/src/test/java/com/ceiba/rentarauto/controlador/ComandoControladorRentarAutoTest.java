package com.ceiba.rentarauto.controlador;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;


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
import com.ceiba.rentarauto.comando.ComandoRentarAuto;
import com.ceiba.rentarauto.modelo.dto.DtoRentarAuto;
import com.ceiba.rentarauto.puerto.dao.DaoRentarAuto;
import com.ceiba.rentarauto.servicio.testdatabuilder.ComandoRentarAutoTestDataBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;


@RunWith(SpringRunner.class)
@ContextConfiguration(classes = ApplicationMock.class)
@WebMvcTest(ComandoControladorRentarAuto.class)
public class ComandoControladorRentarAutoTest {
	
	@Autowired
	private ObjectMapper objectMapper;
	@Autowired 
	private DaoRentarAuto daoRentarAuto;

	@Autowired
	private MockMvc mocMvc;

	@Test
	public void crear() throws Exception {
		// arrange
		ComandoRentarAuto auto = new ComandoRentarAutoTestDataBuilder().build();
		
		
		mocMvc.perform(
				post("/rentauto").contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(auto)));
		
		List<DtoRentarAuto> lista = daoRentarAuto.listar();
		// act - assert
		assertEquals(lista.get(1).getPlaca(), auto.getPlaca());
	}

}
