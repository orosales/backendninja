package com.udemy.backendninja.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.udemy.backendninja.component.ContactConverter;
import com.udemy.backendninja.entity.Contact;
import com.udemy.backendninja.model.ContactModel;
import com.udemy.backendninja.repository.ContactRepository;
import com.udemy.backendninja.service.ContactService;

@Service("contactServiceImpl")
public class ContactServiceImpl implements ContactService{

	@Autowired
	@Qualifier("contactRepository")
	private ContactRepository contactRepository;
	
	@Autowired
	@Qualifier("contactConverter")
	private ContactConverter contactConverter;
	
	@Override
	public ContactModel addContact(ContactModel contactModel) {
		// TODO Auto-generated method stub
		Contact contact =contactRepository.save( contactConverter.convertContactModel2Contact(contactModel) );
		
		return contactConverter.convertContact2ContactModel(contact);
	}

	@Override
	public List<ContactModel> listAllContacts() {
		// TODO Auto-generated method stub
		List<Contact> contacts = contactRepository.findAll();
		List<ContactModel> contactsModel = new ArrayList<ContactModel>();
		
		for(Contact contact: contacts) {
			contactsModel.add( contactConverter.convertContact2ContactModel(contact) );
		}
		return contactsModel;
	}

	@Override
	public Contact findContactById(int id) {
		// TODO Auto-generated method stub
		return contactRepository.findById(id);
		
	}

	@Override
	public void removeContact(int id) {
		// TODO Auto-generated method stub
		Contact contact = findContactById(id);
		if (contact!= null) {
			contactRepository.delete(contact );
		}
	}

	@Override
	public ContactModel findContactByIdModel(int id) {
		return contactConverter.convertContact2ContactModel(findContactById(id));
		
	}
	
	

}
