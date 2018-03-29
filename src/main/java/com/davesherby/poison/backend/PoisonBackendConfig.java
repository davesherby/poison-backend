package com.davesherby.poison.backend;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.davesherby.poison.backend.api.ShutdownController;
import com.davesherby.poison.shutdowner.Shutdowner;

@Configuration
public class PoisonBackendConfig {
	
	private static final Logger logger = LoggerFactory.getLogger(PoisonBackendConfig.class);
	
	@Bean public ShutdownController shutdownController(Shutdowner sd) {
		logger.info("je suis dans PBC");
		return new ShutdownController(sd,"FUCK IT WORKS");
	}

}
