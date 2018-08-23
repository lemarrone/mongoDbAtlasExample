package br.com.marrone.mongoDbAtlasExample.repository;

import br.com.marrone.mongoDbAtlasExample.model.Users;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface UserRepository extends MongoRepository<Users, String> {

    Users findByUsernameEquals(String username);

    List<Users> findFirst10ByNameLikeIgnoreCaseOrderById(String name);
}