package com.ceiba.rentarauto.controlador;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

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
@ContextConfiguration(classes = ApplicationMock.class)
@WebMvcTest(ComandoControladorCalcularRentaAuto.class)
public class ComandoControladorCalcularRentaAutoTest {

	@Autowired
	private MockMvc mocMvc;

	@Test
	public void crear() throws Exception {
		// arrange

		mocMvc.perform(get("/rentauto/totalrenta/BZA485/2020-12-25/2020-12-30").contentType(MediaType.APPLICATION_JSON))
				.andExpect(content().json("{'valor': 450000.0}"));

	}

}
