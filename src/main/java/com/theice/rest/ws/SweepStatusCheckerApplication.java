package com.theice.rest.ws;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;

@ApplicationPath("checker")
public class SweepStatusCheckerApplication extends ResourceConfig {
	
	public SweepStatusCheckerApplication() {
		packages("com.theice.rest.ws.resources");
	}

}
