package net.javaguides.mapper;

import javax.annotation.processing.Generated;
import net.javaguides.dto.UserDTO;
import net.javaguides.entity.User;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-10-08T12:45:41+0530",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.35.0.v20230814-2020, environment: Java 17.0.8.1 (Eclipse Adoptium)"
)
public class AutoUserMapperImpl implements AutoUserMapper {

    @Override
    public UserDTO mapToUserDto(User user) {
        if ( user == null ) {
            return null;
        }

        UserDTO userDTO = new UserDTO();

        userDTO.setEmail( user.getEmail() );
        userDTO.setFirstName( user.getFirstName() );
        userDTO.setId( user.getId() );
        userDTO.setLastName( user.getLastName() );

        return userDTO;
    }

    @Override
    public User mapToUser(UserDTO userDto) {
        if ( userDto == null ) {
            return null;
        }

        User user = new User();

        user.setEmail( userDto.getEmail() );
        user.setFirstName( userDto.getFirstName() );
        user.setId( userDto.getId() );
        user.setLastName( userDto.getLastName() );

        return user;
    }
}
