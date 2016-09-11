package com.flemby.controller.emailController;

import com.flemby.entity.Contact;
import com.flemby.mail.FlembyMail;
import com.flemby.repository.ContactRepository;
import com.flemby.repository.EventRepository;
import com.flemby.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;
import java.text.ParseException;
import java.util.List;

/**
 * Created by Paul on 02/07/2016.
 */
@RestController
public class EmailController {

    @Autowired
    private ContactRepository contactRepository;

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private NotificationRepository notificationRepository;


    @RequestMapping(value = "/upcomingEventsURL/email", method = RequestMethod.POST, produces = {"application/json"})
    public String emailSeniorEvents(@RequestParam("text") String text,
                                    @RequestParam("type") String type,
                                    @RequestParam("name") String name,
                                    @RequestParam("location") String location,
                                    @RequestParam("link") String link,
                                    @RequestParam("publishedDate") String date)
            throws MessagingException {

        List<Contact> contacts;
        String message = "\nFlemby National School - " + type + "\n" + name + "\n" + location + "\n" + date + "\n\n" + text + "\n\nMore info: " + link;

        if (type.equals("School Activity")) {
            contacts = contactRepository.findAll();
        } else {
            contacts = contactRepository.findByType(getEventType(type));
        }
        sendSeniorClassEventEmail(contacts, message, type);
        return "{ \"success\" : \"success\" }";
    }

    @RequestMapping(value = "/notificationURL/email", method = RequestMethod.POST, produces = {"application/json"})
    public String emailNotification(@RequestParam("text") String text,
                                    @RequestParam("type") String type,
                                    @RequestParam("name") String name,
                                    @RequestParam("link") String link,
                                    @RequestParam("publishedDate") String dateStr)
            throws MessagingException, ParseException {

        String school = "School Notification";
        String seniorClass = "Senior Class Notification";
        String juniorClass = "Junior Class Notification";

        List<Contact> contacts;
        String message = "\nFlemby National School \n\n" + type + "\n" + name +  "\n" + dateStr + "\n\n" + text + "\n\nMore info: " + link;

        if (type.equals(school)) {
            contacts = contactRepository.findAll();
        } else if (type.equals(seniorClass)) {
            contacts = contactRepository.findByType("Senior Class");
        } else {
            contacts = contactRepository.findByType("Junior Class");
        }
        sendSeniorClassEventEmail(contacts, message, type);

        return "{ \"success\" : \"success\" }";
    }

    private String getEventType(String type) {
        if (type.equals("Senior Class Event")) {
            return "Senior Class";
        } else {
            return "Junior Class";
        }
    }

    public void sendSeniorClassEventEmail(List<Contact> contacts, String message, String subject) {
        ApplicationContext context = new ClassPathXmlApplicationContext("SpringMail.xml");

        FlembyMail mm = (FlembyMail) context.getBean("flembyMail");
        mm.sendMails(contacts, message, subject);

    }
}
