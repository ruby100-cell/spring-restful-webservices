package net.javaguides.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import net.javaguides.dto.UserDTO;
import net.javaguides.entity.User;
import net.javaguides.exception.EmailAlreadyExistException;
import net.javaguides.exception.ResourceNotFoundException;
import net.javaguides.mapper.AutoUserMapper;
import net.javaguides.mapper.UserMapper;
import net.javaguides.repository.UserRepository;
import net.javaguides.service.UserService;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ModelMapper modelMapper;

	public UserDTO createUser(UserDTO userDto) {
//		 User user1 = UserMapper.mapToUser(user);
//		 User user1 = modelMapper.map(userDto, User.class);
		
		Optional<User> optionalUser = userRepository.findByEmail(userDto.getEmail());
		if(optionalUser.isPresent()) {
			throw new EmailAlreadyExistException("Email Already Exists for User");
		}
		
		User user1 = AutoUserMapper.MAPPER.mapToUser(userDto);
		 User savedUser = userRepository.save(user1);
//		 UserDTO savedUserDto = UserMapper.mapToUserDTO(savedUser);
//		 UserDTO savedUserDto = modelMapper.map(savedUser, UserDTO.class);
		 UserDTO savedUserDto = AutoUserMapper.MAPPER.mapToUserDto(savedUser);
		 return savedUserDto;
	}

	@Override
	public UserDTO getUserById(int id) {
		User user = userRepository.findById(id).orElseThrow(
				()-> new ResourceNotFoundException("User", "id", id)
				);
//		return UserMapper.mapToUserDTO(user);
//		return modelMapper.map(user, UserDTO.class);
		return AutoUserMapper.MAPPER.mapToUserDto(user);
	}

	@Override
	public List<UserDTO> getAllUsers() {
		List<User> users = userRepository.findAll();
//		return users.stream().map(UserMapper::mapToUserDTO).
//				collect(Collectors.toList());
//		return users.stream().map((user)-> modelMapper.map(user,UserDTO.class)).
//				collect(Collectors.toList());
		return users.stream().map((user)-> AutoUserMapper.MAPPER.mapToUserDto(user)).
				collect(Collectors.toList());
	}

	@Override
	public UserDTO updateUser(UserDTO userDto) {
		User existingUser = userRepository.findById(userDto.getId()).orElseThrow(
				() -> new ResourceNotFoundException("User", "id", userDto.getId())
				);
		existingUser.setFirstName(userDto.getFirstName());
		existingUser.setLastName(userDto.getLastName());
		existingUser.setEmail(userDto.getEmail());
		User updateduser = userRepository.save(existingUser);
//		return UserMapper.mapToUserDTO(updateduser);
//		return modelMapper.map(updateduser, UserDTO.class);
		return AutoUserMapper.MAPPER.mapToUserDto(updateduser);
	}

	@Override
	public void deleteUser(int id) {
		User existingUser = userRepository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("User", "id", id)
				);
		userRepository.deleteById(id);
	}

}
