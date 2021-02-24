package dev.luisjrodriguez.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.luisjrodriguez.demo.dto.ContactDTO;
import dev.luisjrodriguez.demo.model.request.ContactRequest;
import dev.luisjrodriguez.demo.model.response.ContactResponse;
import dev.luisjrodriguez.demo.service.ContactService;

@RestController
@RequestMapping("contacts") // http://localhost:8080/contacts
public class ContactController {
	
	@Autowired
	ContactService contactService;

	@GetMapping
	public String getContact() {
		return "get contact was called";
	}

	@PostMapping
	public ContactResponse createContact(@RequestBody ContactRequest contact) {

		ContactResponse returnValue = new ContactResponse();
		
		ContactDTO contactDTO = new ContactDTO();
		BeanUtils.copyProperties(contact, contactDTO);
		
		ContactDTO createdContact = contactService.createContact(contactDTO);
		BeanUtils.copyProperties(createdContact, returnValue);

		return returnValue;
	}

	@PutMapping
	public String putContact() {
		return "put contact was called";
	}

	@DeleteMapping
	public String deleteContact() {
		return "Delete contact was called";
	}
}
