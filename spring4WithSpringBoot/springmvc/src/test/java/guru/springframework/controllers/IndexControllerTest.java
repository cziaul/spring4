package guru.springframework.controllers;

import org.junit.Before;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

public class IndexControllerTest {
	
	private IndexController IndexController;
	private MockMvc mockMvc;
	
	@Before
	public void setup(){
		IndexController = new IndexController();
		mockMvc = MockMvcBuilders.standaloneSetup(IndexController).build();
	}

	/*@Test
	public void testIndex throws Exception {
		mockMvc.perform(get("/"))
			.andExpect(status().isOk())
			.andExpect(view().name("index"));
	}*/

	
}
