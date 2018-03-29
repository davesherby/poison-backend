package com.davesherby.poison.backend.api;

import java.time.ZonedDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.davesherby.poison.shutdowner.Shutdowner;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("shutdown")
public class ShutdownController {

	private static final Logger logger = LoggerFactory.getLogger(ShutdownController.class);

	private Shutdowner shutdowner;

	public ShutdownController(Shutdowner shutdowner) {
		logger.trace("constructor with args");
		this.shutdowner = shutdowner;
	}
	
	public ShutdownController(Shutdowner shutdowner,String qued) {
		logger.trace("constructor with qued : "+qued);
		this.shutdowner = shutdowner;
	}

	public ShutdownController() {
		logger.trace("no args constructor");
	}

	@ApiOperation(value = "Is a shutdown scheduled on this machine ?")
	@RequestMapping(method = RequestMethod.GET,path= {"isShutdownScheduled","iss"})
	public boolean isShutdownScheduled() {
		logger.trace("enter");
		return shutdowner.isShutdownScheduled();
	}

	@ApiOperation(value = "Cancel scheduled shutdown if any, error otherwise")
	@RequestMapping(method = RequestMethod.POST,path="cancelShutdown")
	public void cancelShutdown() {
		shutdowner.cancelShutdown();
	}
	
	@ApiOperation(value = "Schedule a shutdown with a given dateOfShutdown")
	@RequestMapping(method = RequestMethod.POST,path="scheduleShutdown")
	public ZonedDateTime scheduleShutdown(
			@ApiParam(value = "DateTime of wanted shutdown")  @RequestParam("dateOfShutdown") @DateTimeFormat(iso = ISO.DATE_TIME) ZonedDateTime dateOfShutdown) {
		logger.debug("Reception of : "+dateOfShutdown);
		return shutdowner.scheduleShutdown(dateOfShutdown);
	}

	@ApiOperation(value = "Return date of scheduled shutdown")
	@RequestMapping(method=RequestMethod.GET,path="getScheduledShutdownDate")
	public ZonedDateTime getScheduledShutdownDate() {
		return shutdowner.getScheduledShutdownDate();
	}
}
