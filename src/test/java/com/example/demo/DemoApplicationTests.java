package com.example.demo;

import com.example.demo.controllers.EntityController;
import com.example.demo.domain.Entity;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import org.hibernate.event.spi.EntityCopyObserver;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.GsonJsonParser;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class DemoApplicationTests {

	@Autowired
	private MockMvc mockMvc;
	@Test
	public void contextLoads() {
	}

	@Test
	public void creation() throws Exception {

		/*mockMvc.perform(get("/"))
				.andExpect(status().isOk())
				.andExpect(content().string(containsString("Welcome to Spring")));

				*/
		mockMvc.perform(post("http://localhost:8080/chargingSessions")
				.contentType(MediaType.APPLICATION_JSON)
				.content("{" +
						"\"stationId\":" +
						"\"Alessio ss--sss-\"," +
						"\"timestamp\":" +
						"\"2019-05-06T19:00:20.529\"" +
						"}"))
				.andDo(print())
				.andExpect(status().isOk()).andExpect(content().string(containsString("\"stationid\":\"Alessio ss--sss-")));

		mockMvc.perform(post("http://localhost:8080/chargingSessions")
				.contentType(MediaType.APPLICATION_JSON)
				.content("{" +
						"\"stationId\":" +
						"\"SecondSession\"," +
						"\"timestamp\":" +
						"\"2019-05-06T19:00:20.529\"" +
						"}"))
				.andDo(print())
				.andExpect(status().isOk()).andExpect(content().string(containsString("\"stationid\":\"SecondSession")));


	}
	@Test
	public void getting() throws Exception{

		creation();
		mockMvc.perform(get("http://localhost:8080/chargingSessions"))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().string((containsString("Alessio ss--sss-"))))
				.andExpect(content().string(containsString("SecondSession")));

	}

	public String getID() throws Exception  {

		mockMvc.perform(post("http://localhost:8080/chargingSessions")
				.contentType(MediaType.APPLICATION_JSON)
				.content("{" +
						"\"stationId\":" +
						"\"SecondSession\"," +
						"\"timestamp\":" +
						"\"2019-05-06T19:00:20.529\"" +
						"}"))
				.andDo(print());

		String a = mockMvc.perform(get("http://localhost:8080/chargingSessions")).andReturn().getResponse().getContentAsString();
		System.out.println(a.substring(8,44));

		return a.substring(8,44) ;
	}
@Test
	public void putting() throws Exception{
		String a = getID();


		mockMvc.perform(put("http://localhost:8080/chargingSessions/"+a)
				.contentType(MediaType.APPLICATION_JSON))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().string(containsString("SecondSession")))
				.andExpect(content().string(containsString("FINISHED")));
	}



}
