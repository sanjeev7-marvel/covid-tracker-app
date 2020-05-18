package com.covid.tracker.app;

import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.File;
import java.nio.file.Files;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import com.covid.tracker.app.controller.CovidTrackerController;
import com.covid.tracker.app.model.CovidTrackerResponse;
import com.covid.tracker.app.service.CovidTrackerService;
import com.google.gson.Gson;

@RunWith(SpringRunner.class)
@WebMvcTest(CovidTrackerController.class)
public class CovidTrackerControllerTest {

	@Autowired
	private MockMvc mockMvc;

	private Gson gson = new Gson();

	@MockBean
	private CovidTrackerService covidTrackerService;

	@Test
	public void trackByStateCodeTest() throws Exception {
		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource("output.json").getFile());
		String output = new String(Files.readAllBytes(file.toPath()));
		CovidTrackerResponse response = gson.fromJson(output, CovidTrackerResponse.class);
		Mockito.when(covidTrackerService.trackByStateCode(Mockito.anyString())).thenReturn(response);

		MvcResult result = this.mockMvc.perform(get("/covidtracker/state/{code}", "AK"))
				.andDo(MockMvcResultHandlers.print()).andExpect(status().isOk()).andReturn();
		String content = result.getResponse().getContentAsString();
		System.out.println("content => " + content);
		assertNotNull(content);
	}

};