package dev.luisjrodriguez.demo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import dev.luisjrodriguez.demo.entity.ContactEntity;

@Repository
public interface ContactRepository extends CrudRepository<ContactEntity, Long> {
	//ContactEntity findContactByEmail(String email);
}
