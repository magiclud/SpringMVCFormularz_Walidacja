package net.codejava.spring.model;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import net.codejava.spring.validator.Phone;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.context.annotation.PropertySource;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
// tells Hibernate that this class represents an object that we can persist.
@Table(name = "USERS")
// annotation tells Hibernate which table to map properties in this class to
public class User {

	@Id
	// will be unique for all events persisted
	@Column(name = "ID")
	@GeneratedValue
	// annotation says that this value will be determined by the datasource, not
	// by the code.
	private Integer id;

	// @Size(min = 2, max = 30)
	@NotEmpty
	@Column(name = "USERNAME")
	// annotation is used to map this property to the USERNAME column in the
	// USERS table.
	private String username;
	@NotNull
	@Size(min = 5)
	@Column(name = "PASSWORD")
	private String password;
	@NotEmpty
	@Email
	@Column(name = "EMAIL")
	private String email;
	@DateTimeFormat(pattern = "MM/dd/yyyy")
	@NotNull
	@Past
	@Column(name = "BIRTHDATE")
	private Date birthDate;
	private String profession;
	@Phone
	@Size(min = 2, max = 9)
	@Column(name = "PHONE")
	private String phone;
	@NotNull
	@Column(name = "GENDER")
	private Gender gender;

	public enum Gender {
		MALE, FEMALE
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	// getters and setters...

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
}
