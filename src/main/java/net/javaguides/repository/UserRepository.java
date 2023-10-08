package net.javaguides.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import net.javaguides.entity.User;

public interface UserRepository extends MongoRepository<User, Integer>{
	
	Optional<User> findByEmail(String email);

}
