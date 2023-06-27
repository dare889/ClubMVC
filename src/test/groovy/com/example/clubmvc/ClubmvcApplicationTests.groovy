package com.example.clubmvc

import org.springframework.context.ApplicationContext
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class ClubmvcApplicationTests {

	@Autowired
	private ApplicationContext applicationContext;

	@Test
	void contextLoads() {
		// Verify that the application context is not null
		assertThat(applicationContext).isNotNull();
	}

}
