package com.spring.pos.model;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tblposition")
public class Position {

	private static final Logger LOGGER = LogManager.getLogger(Position.class);

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "positionid")
	private long positionID;

	@Column(name = "positionname", length = 50)
	private String positionName;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "positionid", referencedColumnName = "positionid")
	private List<User> users;
	
	
	public Position() {
	}
	
	public Position(long positionID, String positionName, List<User> users) {
		this.positionID = positionID;
		this.positionName = positionName;
		this.users = users;
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

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public class MetaData {
		public static final String POSITIONID = "PositionID";
		public static final String POSITIONNAME = "PositionName";
	}

}
