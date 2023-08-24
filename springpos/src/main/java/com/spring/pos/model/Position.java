package com.spring.pos.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Position {

	private static final Logger LOGGER = LogManager.getLogger(Position.class);

	private int positionID =-1;

	private String positionName;

	public int getPositionID() {
		return positionID;
	}

	public Position() {
	}

	public Position(ResultSet resultSet) {
		try {
			this.positionID = resultSet.getInt(MetaData.POSITIONID);
			this.positionName = resultSet.getString(MetaData.POSITIONNAME);
		} catch (SQLException e) {
			LOGGER.debug(e.getLocalizedMessage(), e);
		}

	}

	public void setPositionID(int positionID) {
		this.positionID = positionID;
	}

	public String getPositionName() {
		return positionName;
	}

	public void setPositionName(String positionName) {
		this.positionName = positionName;
	}

	public class MetaData {
		public static final String POSITIONID = "PositionID";
		public static final String POSITIONNAME = "PositionName";
	}

}
