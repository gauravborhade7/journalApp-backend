package com.borhade.JournalApp.repository;

import com.borhade.JournalApp.entity.JournalEntry;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JournalEntryRepository extends MongoRepository<JournalEntry, ObjectId> {//journaletry is collection name and string is id data type
}
