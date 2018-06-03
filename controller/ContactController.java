package pl.dmcs.rkotas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.dmcs.rkotas.model.Contact;
import pl.dmcs.rkotas.model.request.AddContactRequest;
import pl.dmcs.rkotas.repository.ContactRepository;

import java.util.List;

@RestController
@RequestMapping("/contacts")
public class ContactController {

    private ContactRepository contactRepository;

    @Autowired
    public ContactController(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Contact> findAllContacts() {
        return contactRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public void addContact(@RequestBody AddContactRequest addContactRequest) {

        Contact contact = new Contact();
        contact.setFirstname(addContactRequest.getFirstname());
        contact.setLastname(addContactRequest.getLastname());
        contactRepository.save(contact);

    }
}
