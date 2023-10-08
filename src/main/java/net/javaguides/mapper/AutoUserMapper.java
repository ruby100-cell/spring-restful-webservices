package net.javaguides.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import net.javaguides.dto.UserDTO;
import net.javaguides.entity.User;

@Mapper
public interface AutoUserMapper {
	
	AutoUserMapper MAPPER = Mappers.getMapper(AutoUserMapper.class);
	
	UserDTO mapToUserDto(User user);
	User mapToUser(UserDTO userDto);

}
