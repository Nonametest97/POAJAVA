package com.spring.pos.model;

import java.sql.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tbluser")
public class User {
	private static final Logger LOGGER = LogManager.getLogger(User.class);

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "userid")
	private int userID;

	@Column(name = "username")
	private String userName;

	@Column(name = "gender")
	private String gender;

	@Column(name = "dateofbirth")
	private Date dateOfBirth;

	@Column(name = "password")
	private String password;

	@Column(name = "description")
	private String description;

	@Column(name = "salary", columnDefinition = "double default 0.00")
	private double salary;

	@Column(name = "phone")
	private String phone;

	@Column(name = "active")
	private String active;

	@Lob
	@Column(name = "photo", columnDefinition = "LONGBLOB", nullable = true)
	@Basic(fetch = FetchType.LAZY)
	private byte[] photo;

	@ManyToOne
	@JoinColumn(name = "positionid", referencedColumnName = "positionid")
	private Position position;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "userid", referencedColumnName = "userid")
	private List<AddStock> addStocks;

	public User() {
	}


	public List<AddStock> getAddStocks() {
		return addStocks;
	}


	public void setAddStocks(List<AddStock> addStocks) {
		this.addStocks = addStocks;
	}


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

	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
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
