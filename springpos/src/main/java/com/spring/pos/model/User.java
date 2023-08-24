package com.spring.pos.model;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class User {
	private static final Logger LOGGER = LogManager.getLogger(User.class);

	private int userID;

	private String userName;

	private String gender;

	private Date dateOfBirth;

	private String password;

	private String description;

	private double salary = 0.00;

	private String phone;

	private String active;

	private Position position;

	private String photo;

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public User() {

	}

//	public User(ResultSet resultSet) {
//		super();
//		try {
//			this.userID = resultSet.getInt(User.Metadata.USERID);
//			this.userName = (String) getOrDefault(resultSet.getString(User.Metadata.USERNAME));
//			this.gender = (String) getOrDefault(resultSet.getString(User.Metadata.GENDER));
//			this.dateOfBirth = (Date) getOrDefault(resultSet.getDate(User.Metadata.DATEOFBIRTH), null);
//			this.password = (String) getOrDefault(resultSet.getString(User.Metadata.PASSWORD));
//			this.description = (String) getOrDefault(resultSet.getString(User.Metadata.DESCRIPTION));
//			this.salary = (double) getOrDefault(resultSet.getDouble(User.Metadata.SALARY));
//			this.phone = (String) getOrDefault(resultSet.getString(User.Metadata.PHONE));
//			this.active = (String) getOrDefault(resultSet.getString(User.Metadata.ACTIVE));
//
//			try {
//				this.position = Services.POSITION_SERVICE.getPositionById(resultSet.getInt(User.Metadata.POSITIONID));
//			} catch (Exception e) {
//				LOGGER.debug(e.getLocalizedMessage(), e);
//			}
//
//			this.photo = (String) getOrDefault(resultSet.getString(User.Metadata.PHOTO));
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//
//	}

	public Object getOrDefault(Object value, String defaultValue) {
		return value == null ? defaultValue : value;
	}

	public Object getOrDefault(Object value) {
		return getOrDefault(value, "");
	}
	
	public class Metadata {
		public static final String USERID = "UserID";
		public static final String USERNAME = "UserName";
		public static final String GENDER = "Gender";
		public static final String DATEOFBIRTH = "DateOfBirth";
		public static final String PASSWORD = "Password";
		public static final String DESCRIPTION = "Description";
		public static final String SALARY = "Salary";
		public static final String PHONE = "Phone";
		public static final String ACTIVE = "Active";
		public static final String POSITIONID = "PositionID";
		public static final String PHOTO = "Photo";
	}

}
