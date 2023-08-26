package com.spring.pos.model.response;

public class PositionResponse {

	private long positionID;

	private String positionName;

	public PositionResponse() {
	}

	public long getPositionID() {
		return positionID;
	}

	public void setPositionID(long positionID) {
		this.positionID = positionID;
	}

	public String getPositionName() {
		return positionName;
	}

	public void setPositionName(String positionName) {
		this.positionName = positionName;
	}

}
