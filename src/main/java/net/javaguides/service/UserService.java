package net.javaguides.service;

import java.util.List;

import net.javaguides.dto.UserDTO;
import net.javaguides.entity.User;

public interface UserService {
	
	public UserDTO createUser(UserDTO userDto);
	
	public UserDTO getUserById(int id);
	
	public List<UserDTO> getAllUsers();
	
	public UserDTO updateUser(UserDTO userDto);
	
	public void deleteUser(int id);

}
