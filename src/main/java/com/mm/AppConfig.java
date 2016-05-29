package com.mm;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import com.mm.rest.UserRest;

@Component
@ApplicationPath("api")
public class AppConfig extends ResourceConfig {
	
	public AppConfig() {
		register(UserRest.class);
	}

}
