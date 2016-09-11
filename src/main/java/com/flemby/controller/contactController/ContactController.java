package com.flemby.controller.contactController;

import com.flemby.entity.Contact;
import com.flemby.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

/**
 * Created by Paul on 09/09/2016.
 */
@RestController
public class ContactController {

    @Autowired
    private ContactRepository contactRepository;

    @RequestMapping(value = "/contact/delete/{id}", method = RequestMethod.POST,  produces = {"application/json"})
    public String contactDelete(@PathVariable int id) throws IOException, ParseException {
        contactRepository.delete(id);
        String deleted = "{ \"deleted\" : \"deleted\" }";
        return deleted;
    }

    @RequestMapping(value = "/contactUpdate/{id}", method = RequestMethod.POST)
    public ResponseEntity<Contact> contactUpdate(@RequestParam("firstName") String firstName,
                                                 @RequestParam("surname") String surname,
                                                 @RequestParam("email") String email,
                                                 @RequestParam("number") String number,
                                                 @RequestParam("type") String type,
                                                 @PathVariable int id) throws IOException, ParseException {

        Contact contact = contactRepository.findOne(id);
        contact.setFirstName(firstName);
        contact.setSurname(surname);
        contact.setEmail(email);
        contact.setNumber(number);
        contact.setType(type);
        contactRepository.save(contact);
        return new ResponseEntity<Contact>(contact, HttpStatus.OK);
    }

    @RequestMapping(value = "/contact/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Contact> getCalendarMonth(@PathVariable int id) throws ParseException {
        return new ResponseEntity<Contact>(contactRepository.findOne(id), HttpStatus.OK);
    }

    @RequestMapping(value = "/allContacts", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Contact>> getAllContacts() throws ParseException {
        return new ResponseEntity<List<Contact>>(contactRepository.findAll(), HttpStatus.OK);
    }

    @RequestMapping("/seniorContacts")
    public ResponseEntity<List<Contact>> getSeniorContacts() {
        return new ResponseEntity<List<Contact>>(contactRepository.findByType("Senior Class"), HttpStatus.OK);
    }

    @RequestMapping("/juniorContacts")
    public ResponseEntity<List<Contact>> getJuniorContacts() {
        return new ResponseEntity<List<Contact>>(contactRepository.findByType("Junior Class"), HttpStatus.OK);
    }

    @RequestMapping(value = "/addNewContact", method = RequestMethod.POST)
    public ResponseEntity<Contact> updateUpcomingEvent(@RequestParam("firstName") String firstName,
                                                       @RequestParam("surname") String surname,
                                                       @RequestParam("email") String email,
                                                       @RequestParam("number") String number,
                                                       @RequestParam("type") String type) throws IOException, ParseException {

        Contact contact = new Contact();
        contact.setFirstName(firstName);
        contact.setSurname(surname);
        contact.setEmail(email);
        contact.setNumber(number);
        contact.setType(type);
        contactRepository.save(contact);
        return new ResponseEntity<Contact>(contact, HttpStatus.OK);
    }
}
