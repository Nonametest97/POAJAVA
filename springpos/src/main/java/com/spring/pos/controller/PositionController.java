package com.spring.pos.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.pos.model.Position;
import com.spring.pos.model.request.PositionForm;
import com.spring.pos.model.response.PositionResponse;
import com.spring.pos.services.PositionService;

import jakarta.servlet.http.HttpServletResponse;

@RestController
public class PositionController {

	@Autowired
	private PositionService service;

	@GetMapping("/position/{id}")
	public ResponseStatus getPositionById(@PathVariable(required = true) long id, @RequestParam(value = "detail", required = false) boolean detail) {
		Position position = service.getPositionById(id);

		String status = ResponseStatus.STATUS_FOUND;
		String messages = "";
		if (position == null) {
			status = ResponseStatus.STATUS_NOTFOUND;
			messages = "Could not find Position by Id [" + id + "]";
		}

		Object result = position;
		if (!detail) {
			PositionResponse positionResponse = new PositionResponse();
			BeanUtils.copyProperties(position, positionResponse);
			result = positionResponse;
		}

		ResponseStatus responseStatus = new ResponseStatus();
		responseStatus.setStatus(status);
		responseStatus.setMessages(messages);
		responseStatus.setResult(result);

		return responseStatus;
	}

	@PostMapping("/position")
	public ResponseStatus insertPosition(@RequestBody PositionForm form, HttpServletResponse response) {
		ResponseStatus responseStatus = new ResponseStatus();
		responseStatus.setStatus(ResponseStatus.STATUS_USER_ERROR);
		responseStatus.setMessages("positionName must not be empty");

		response.setStatus(response.SC_BAD_REQUEST);

		if (StringUtils.isNotBlank(form.getPositionName())) {
			PositionResponse position = service.insertPosition(form);
			responseStatus.setStatus(ResponseStatus.STATUS_SUCCESS);
			responseStatus.setResult(position);
			responseStatus.setMessages("");

			response.setStatus(response.SC_CREATED);
		}

		return responseStatus;

	}

	@DeleteMapping("/position/{id}")
	public ResponseStatus deletePositionById(@PathVariable(required = true) long id) {
		boolean isDelete = service.deleteById(id);

		ResponseStatus responseStatus = new ResponseStatus();
		responseStatus.setStatus(isDelete ? ResponseStatus.STATUS_SUCCESS : ResponseStatus.STATUS_NOTFOUND);
		responseStatus.setMessages(isDelete ? "Position has been deleted" : "Position ID can not be deleted or not exists");
		;
		return responseStatus;
	}

	@PatchMapping("/position/{id}")
	public ResponseStatus updatePositionById(@PathVariable(required = true) long id, @RequestBody PositionForm form) {
		Position position = service.updateById(id, form);
		ResponseStatus responseStatus = new ResponseStatus(ResponseStatus.STATUS_NOTFOUND, "Position fail to update with id [" + id + "]");

		if (position != null) {
			responseStatus.setMessages("Position has been updated");
			responseStatus.setStatus(ResponseStatus.STATUS_SUCCESS);

			PositionResponse response = new PositionResponse();
			BeanUtils.copyProperties(position, response);
			responseStatus.setResult(response);
		}

		return responseStatus;
	}

}
