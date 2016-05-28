package com.mm;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SimpleSpringCrudApplication.class)
@WebAppConfiguration
public class SimpleSpringCrudApplicationTests {

	@Test
	public void contextLoads() {
	}
	
	@Test
	public void dummyTest() {
		assertEquals(1, 1);
	}
	
}
