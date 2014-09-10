package net.codejava.spring.model;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import net.codejava.spring.validator.Phone;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

public class User {
//	@Size(min = 2, max = 30)
	@NotEmpty
	private String username;
	@NotNull
	@Size(min = 5)
	private String password;
	@NotEmpty
	@Email
	private String email;
	@DateTimeFormat(pattern = "MM/dd/yyyy")
	@NotNull
	@Past
	private Date birthDate;
	private String profession;
	@Phone
	private String phone;
	@NotNull
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

}
