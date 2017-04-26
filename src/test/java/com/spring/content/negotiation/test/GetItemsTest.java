package com.spring.content.negotiation.test;

import java.nio.charset.Charset;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(value = SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = { "classpath:/test-context.xml" })
public class GetItemsTest {
	private Logger logger = LoggerFactory.getLogger(GetItemsTest.class);
	private MediaType JsonContentType = new MediaType(
			MediaType.APPLICATION_JSON.getType(),
			MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8"));

	private MediaType XmlContentType = new MediaType(
			MediaType.APPLICATION_XML.getType(),
			MediaType.APPLICATION_XML.getSubtype(), Charset.forName("utf8"));
	private MockMvc mockMvc;
	@Autowired(required = true)
	private WebApplicationContext context;

	@Before
	public void setup() throws Exception {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
	}

	//@Test
	public void saveItemJSONTest() throws Exception {
		MvcResult result = mockMvc
				.perform(
						MockMvcRequestBuilders.get("/getItems.json")
								.contentType(JsonContentType))
				.andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
		String resultContent = result.getResponse().getContentAsString();
		logger.info(resultContent);
	}

	@Test
	public void saveItemXMLTest() throws Exception {
		MvcResult result = mockMvc
				.perform(
						MockMvcRequestBuilders.get("/getItems.xml")
								.contentType(XmlContentType))
				.andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
		String resultContent = result.getResponse().getContentAsString();
		logger.info(resultContent);
	}
}
