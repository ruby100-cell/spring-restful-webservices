package net.javaguides.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import net.javaguides.dto.UserDTO;
import net.javaguides.entity.User;
import net.javaguides.exception.ErrorDetails;
import net.javaguides.exception.ResourceNotFoundException;
import net.javaguides.service.UserService;

@Tag(
		name = "CRUD Rest Apis for User Resource",
		description = "CRUD Rest Apis Create User,Update User,Get User, get All Users,Delete User"
		)
@RestController
@AllArgsConstructor
@RequestMapping("/api/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Operation(summary = "create User Rest Api",
			description = "Create user rest api is used to save user in a db")
	@ApiResponse(
			responseCode = "201",
			description = "HTTP Status 201 created")
	@PostMapping("/createUser")
	public ResponseEntity<UserDTO> createUser(@Valid @RequestBody UserDTO userDto){
		UserDTO savedUser = userService.createUser(userDto);
		return new ResponseEntity<UserDTO>(savedUser, HttpStatus.CREATED);
	}
	
	@Operation(summary = "Get User by Id Rest Api",
			description = "Get user by id rest api is used to get a single user from the db")
	@ApiResponse(
			responseCode = "200",
			description = "HTTP Status 200 SUCCESS")
	@GetMapping("{id}")
	public ResponseEntity<UserDTO> getUserById(@PathVariable int id){
		UserDTO user = userService.getUserById(id);
		return new ResponseEntity<UserDTO>(user, HttpStatus.OK);
	}
	
	@Operation(summary = "Get All Users Rest Api",
			description = "Get All users rest api is used to get a all users from the db")
	@ApiResponse(
			responseCode = "200",
			description = "HTTP Status 200 SUCCESS")
	@GetMapping
	public ResponseEntity<List<UserDTO>> getAllUsers(){
		List<UserDTO> users = userService.getAllUsers();
		return new ResponseEntity<List<UserDTO>>(users, HttpStatus.OK);
	}
	
	@Operation(summary = "Update User Rest Api",
			description = "Update user rest api is used to update a particular user in the db")
	@ApiResponse(
			responseCode = "200",
			description = "HTTP Status 200 SUCCESS")
	@PutMapping("{id}")
	public ResponseEntity<UserDTO> updateUser(@PathVariable int id,@RequestBody @Valid UserDTO userDto){
		userDto.setId(id);
		UserDTO updateUser = userService.updateUser(userDto);
		return ResponseEntity.ok(updateUser);
	}
	
	@Operation(summary = "Delete User Rest Api",
			description = "Delete user rest api is used to delete a particular user from the db")
	@ApiResponse(
			responseCode = "200",
			description = "HTTP Status 200 SUCCESS")
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteUser(@PathVariable int id){
		userService.deleteUser(id);
		return new ResponseEntity<>("User successfully deleted !!", HttpStatus.OK);
	}
	
//	@ExceptionHandler(ResourceNotFoundException.class)
//	public ResponseEntity<ErrorDetails> handleResourceNotFoundException(ResourceNotFoundException exception, 
//																		WebRequest webRequest){
//		ErrorDetails errorDetails = new ErrorDetails(
//				LocalDateTime.now(),
//				exception.getMessage(),
//				webRequest.getDescription(false),
//				"USER_NOT_FOUND");
//		return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
//	}

}
