package net.javaguides.mapper;

import net.javaguides.dto.UserDTO;
import net.javaguides.entity.User;

public class UserMapper {
	
	public static UserDTO mapToUserDTO(User user) {
		UserDTO userDto = new UserDTO(user.getId(), 
				user.getFirstName(),
				user.getLastName(),
				user.getEmail());
		return userDto;
	}
	
	public static User mapToUser(UserDTO userDto) {
		User user = new User(userDto.getId(), 
				userDto.getFirstName(),
				userDto.getLastName(),
				userDto.getEmail());
		return user;
	}

}
