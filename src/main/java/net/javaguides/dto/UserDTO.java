package net.javaguides.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

@Schema(
		description = "UserDto Model Information")
public class UserDTO {
	
	private int id;
	@NotEmpty(message = "User first name should not be null or empty")
	@Schema(description = "User First Name")
	private String firstName;
	@NotEmpty(message = "User last name should not be null or empty")
	@Schema(description = "User last Name")
	private String lastName;
	@NotEmpty(message = "User email should not be null or empty")
	@Email(message = "Email address should be valid")
	@Schema(description = "User Email Address")
	private String email;
	
	public UserDTO(int id, String firstName, String lastName, String email) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	public UserDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
