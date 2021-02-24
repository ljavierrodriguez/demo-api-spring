package dev.luisjrodriguez.demo.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.luisjrodriguez.demo.ContactRepository;
import dev.luisjrodriguez.demo.dto.ContactDTO;
import dev.luisjrodriguez.demo.entity.ContactEntity;

@Service
public class ContactServiceImpl implements ContactService{

	@Autowired
	ContactRepository contactRepository;
	
	@Override
	public ContactDTO createContact(ContactDTO contact) {
		// TODO Auto-generated method stub
		ContactEntity contactEntity = new ContactEntity();
		BeanUtils.copyProperties(contact, contactEntity);
		
		contactEntity.setContactId("testContactId");
		
		ContactEntity storedContactEntity = contactRepository.save(contactEntity);
		
		ContactDTO returnValue = new ContactDTO();
		BeanUtils.copyProperties(storedContactEntity, returnValue);
		
		return returnValue;
	}

}
