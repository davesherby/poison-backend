package com.davesherby.poison.backend.api;

import java.time.ZonedDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ScheduledShutdown {

	@SuppressWarnings("unused")
	private static final Logger logger = LoggerFactory.getLogger(ScheduledShutdown.class);
	
	private ZonedDateTime scheduledDate;

	public ZonedDateTime getScheduledDate() {
		return scheduledDate;
	}

	public void setScheduledDate(ZonedDateTime scheduledDate) {
		this.scheduledDate = scheduledDate;
	}
	
	
}
