package com.spring.pos.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

public class ResponseStatus {

	public static final String STATUS_SUCCESS = "SUCCESS";

	public static final String STATUS_FOUND = "FOUND";

	public static final String STATUS_NOTFOUND = "NOT FOUND";

	public static final String STATUS_USER_ERROR = "USER ERROR";

	public static final String STATUS_SERVER_ERROR = "SERVER ERROR";

	private String status;

	private List<String> messages;

	private Object result;

	public ResponseStatus() {
	}
	
	public ResponseStatus(String status) {
		this.status = status;
	}
	

	public ResponseStatus(String status, String message) {
		this.status = status;
		setMessages(message);
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Object getResult() {
		return result;
	}

	public void setResult(Object result) {
		this.result = result;
	}

	public List<String> getMessages() {
		return messages;
	}

	public void setMessages(List<String> messages) {
		this.messages = messages;
	}

	public void addMessage(String message) {
		if (StringUtils.isBlank(message))
			return;

		if (this.messages == null) {
			this.messages = new ArrayList<String>();
		}

		messages.add(message);
	}

	public void setMessages(String message) {
		this.messages = null;
		addMessage(message);
	}

}
