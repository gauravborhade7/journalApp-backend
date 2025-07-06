package com.borhade.JournalApp.repository;

import com.borhade.JournalApp.entity.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, ObjectId> {//journaletry is collection name and string is id data type
    User findByUserName(String userName);

    void deleteByUserName(String username);
}

