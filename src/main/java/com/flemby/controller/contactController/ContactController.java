package com.flemby.controller.contactController;

import com.flemby.entity.Contact;
import com.flemby.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.List;

/**
 * Created by Paul on 09/09/2016.
 */
@RestController
public class ContactController {

    @Autowired
    private ContactRepository contactRepository;

    @RequestMapping(value = "/allContacts", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Contact>> getPreviousEvents() throws ParseException {

        return new ResponseEntity<List<Contact>>(contactRepository.findAll(), HttpStatus.OK);
    }

    @RequestMapping("/contactsSeniorURL")
    public String classTypeSeniorContacts(Model model) {
        model.addAttribute("contacts", contactRepository.findByType("Senior Class"));
        return "contactsSeniorURL";
    }

    @RequestMapping("/contactsJuniorURL")
    public String classTypeJuniorContacts(Model model) {
        model.addAttribute("contacts", contactRepository.findByType("Junior Class"));
        return "contactsJuniorURL";
    }
}
