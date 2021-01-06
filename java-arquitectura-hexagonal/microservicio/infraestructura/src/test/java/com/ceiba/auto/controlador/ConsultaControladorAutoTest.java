package com.ceiba.auto.controlador;

import static org.hamcrest.CoreMatchers.is;
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
import com.ceiba.auto.modelo.dto.DtoAuto;
import com.ceiba.auto.puerto.dao.DaoAuto;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = ApplicationMock.class)
@WebMvcTest(ConsultaControladorAuto.class)
public class ConsultaControladorAutoTest {

	@Autowired
	private MockMvc mocMvc;
	@Autowired
	private DaoAuto daoAuto;

	@Test
	public void listar() throws Exception {
		// arrange
		List<DtoAuto> retornoAutos;
		// act - assert
		retornoAutos = daoAuto.listar();
		mocMvc.perform(get("/autos").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(jsonPath("$[0].placa", is(retornoAutos.get(0).getPlaca())));

	}

	@Test
	public void listarDisponibles() throws Exception {
		// arrange
		List<DtoAuto> retornoAutos;
		retornoAutos = daoAuto.listarDisponibles();
		// act - assert
		mocMvc.perform(get("/autos/disponibles").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(jsonPath("$[0].placa", is(retornoAutos.get(0).getPlaca())));
	}

	@Test
	public void listarRentados() throws Exception {
		// arrange
		List<DtoAuto> retornoAutos;
		retornoAutos = daoAuto.listarRentados();
		// act - assert
		mocMvc.perform(get("/autos/rentados").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(jsonPath("$[0].placa", is(retornoAutos.get(0).getPlaca())));
	}

}
