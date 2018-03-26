package com.davesherby.poison.backend.api;

import java.time.ZonedDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.davesherby.poison.shutdowner.Shutdowner;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("shutdown")
public class ShutdownController {
	
	
	private static final Logger logger = LoggerFactory.getLogger(ShutdownController.class);
	
	private Shutdowner shutdowner;
	
	public ShutdownController(Shutdowner shutdowner) {
		this.shutdowner = shutdowner;
	}

	@ApiOperation(
	        value = "Permet de prendre la tête ou pas")
	@RequestMapping(method=RequestMethod.GET)
	public boolean isShutdownScheduled() {
		logger.trace("enter");
		return shutdowner.isShutdownScheduled();
	}

	public void cancelShutdown() {
		shutdowner.cancelShutdown();
	}

	public ZonedDateTime scheduleShutdown(ZonedDateTime dateOfShutdown) {
		return shutdowner.scheduleShutdown(dateOfShutdown);
	}

	public ZonedDateTime getScheduledShutdownDate() {
		return shutdowner.getScheduledShutdownDate();
	}
	


}
