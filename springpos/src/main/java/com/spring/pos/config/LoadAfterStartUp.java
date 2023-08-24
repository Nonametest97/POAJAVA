package com.spring.pos.config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class LoadAfterStartUp {

	private static final Logger logger = LogManager.getLogger(LoadAfterStartUp.class);

	@Value("${server.servlet.context-path}")
	private String contextPath;

	@EventListener(ApplicationReadyEvent.class)
	public void display() {
		logger.info("Server= {}", contextPath);
	}

}
