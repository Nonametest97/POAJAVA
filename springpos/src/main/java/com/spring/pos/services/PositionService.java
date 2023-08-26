package com.spring.pos.services;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.pos.model.Position;
import com.spring.pos.model.request.PositionForm;
import com.spring.pos.model.response.PositionResponse;
import com.spring.pos.repo.PositionRepo;

import io.micrometer.common.util.StringUtils;

@Service
public class PositionService {

	@Autowired
	private PositionRepo repo;

	public Position getPositionById(long id) {
		Optional<Position> position = repo.findById(id);
		if (!position.isPresent()) {
			return null;
		}

		return position.get();
	}

	public PositionResponse insertPosition(PositionForm form) {
		Position position = new Position();
		BeanUtils.copyProperties(form, position);
		Position insertedPosition = repo.save(position);

		PositionResponse positionResponse = new PositionResponse();
		BeanUtils.copyProperties(insertedPosition, positionResponse);

		return positionResponse;
	}

	public boolean deleteById(long id) {
		boolean isDelete = false;

		Position position = getPositionById(id);
		if (position != null) {
			repo.deleteById(id);
			isDelete = true;
		}

		return isDelete;
	}

	public Position updateById(long id, PositionForm form) {
		Position position = getPositionById(id);
		String positionName = form.getPositionName();
		if (position == null || form == null || StringUtils.isBlank(positionName)) {
			return null;
		}

		position.setPositionName(positionName);
		repo.save(position);
		return position;
	}

}
