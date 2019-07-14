package com.xantrix.webapp;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.xantrix.webapp.controller.SalutiRestController;

@RunWith(SpringRunner.class)
@WebMvcTest(SalutiRestController.class)
public class TestRestController {
	
	@Autowired
	private MockMvc mvc;
	
	@Test
	public void testGreetingsController() throws Exception {
		mvc.perform(get("/api/test")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$")
				.value("Saluti, sono il tuo primo web services"))
				.andDo(print());

	}
	
	@Test
	public void testgetSaluti2() throws Exception {
		mvc.perform(get("/api/test/Antonio")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$")
				.value("Saluti, Antonio hai usato il tuo primo web service"))
				.andDo(print());
	}

}
