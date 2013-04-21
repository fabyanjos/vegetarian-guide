package com.fabiale.vegetarianguide.web;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fabiale.vegetarianguide.model.Restaurant;
import com.fabiale.vegetarianguide.service.RestaurantService;
import com.fabiale.vegetarianguide.spring.RestTemplateConfig;
import com.fabiale.vegetarianguide.spring.WebConfig;
import com.fabiale.vegetarianguide.spring.context.SpringConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {WebConfig.class, SpringConfig.class, RestTemplateConfig.class})
@WebAppConfiguration
public class RestaurantControllerTest {
	
	@Autowired
    private WebApplicationContext wac;
	
	private MockMvc mockMvc;
	@Autowired RestaurantService service;
	 
    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }
    
    @Test
    public void postSomething() throws Exception {
    	Restaurant r = new Restaurant();
    	r.setLatitude(52.52983150000001);
    	r.setLongitude(13.340975800000024);
    	service.getNearBy(r);
    }

}
