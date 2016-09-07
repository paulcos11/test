package com.flemby.controller.notificationController;

import com.flemby.entity.Notification;
import com.flemby.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by Paul on 06/09/2016.
 */
@RestController
public class NotificationController {

    @Autowired
    private NotificationRepository notificationRepository;

    @RequestMapping(value = "/notificationSave", method = RequestMethod.POST)
    public ResponseEntity<Notification> newNotification(@RequestBody Notification notification, UriComponentsBuilder ucBuilder) {
        notification.setType("School Notification");
        notificationRepository.save(notification);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/user/{id}").buildAndExpand(notification.getId()).toUri());
        return new ResponseEntity<Notification>(notification, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/juniorNotificationSave", method = RequestMethod.POST)
    public ResponseEntity<Notification> newJuniorNotification(@RequestBody Notification notification, UriComponentsBuilder ucBuilder) {
        notification.setType("Junior Class Notification");
        notificationRepository.save(notification);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/user/{id}").buildAndExpand(notification.getId()).toUri());
        return new ResponseEntity<Notification>(notification, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/seniorNotificationSave", method = RequestMethod.POST)
    public ResponseEntity<Notification> newSeniorNotification(@RequestBody Notification notification, UriComponentsBuilder ucBuilder) {
        notification.setType("Senior Class Notification");
        notificationRepository.save(notification);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/user/{id}").buildAndExpand(notification.getId()).toUri());
        return new ResponseEntity<Notification>(notification, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/updateNotification/{id}", method = RequestMethod.POST)
    public ResponseEntity<Notification> updateNotification(@RequestParam("type") String type,
                                                     @RequestParam("name") String name,
                                                     @RequestParam("link") String link,
                                                     @RequestParam("text") String text,
                                                     @RequestParam("publishedDate") String publishedDate,
                                                     @PathVariable int id) throws IOException, ParseException {


        System.out.println("HelloWorldNotification");
        Notification notification = notificationRepository.findOne(id);
        notification.setType(type);
        notification.setName(name);
        notification.setLink(link);
        notification.setText(text);
        String dateStr = publishedDate;
        DateFormat format1 = new SimpleDateFormat("dd/MM/yyyy");
        Date date;
        date = format1.parse(dateStr);
        notification.setPublishedDate(date);
        notificationRepository.save(notification);
        return new ResponseEntity<Notification>(notification, HttpStatus.OK);
    }

    @RequestMapping(value = "/schoolNotify", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Notification>> getSchoolNotifications() throws ParseException {
        String type = "School Notification";
        return new ResponseEntity<List<Notification>>(notificationRepository.findByType(type), HttpStatus.OK);
    }

    @RequestMapping(value = "/juniorNotify", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Notification>> getJuniorNotifications() throws ParseException {
        String type = "Junior Class Notification";
        return new ResponseEntity<List<Notification>>(notificationRepository.findByType(type), HttpStatus.OK);
    }

    @RequestMapping(value = "/seniorNotify", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Notification>> getSeniorNotifications() throws ParseException {
        String type = "Senior Class Notification";
        return new ResponseEntity<List<Notification>>(notificationRepository.findByType(type), HttpStatus.OK);
    }

    @RequestMapping(value = "/notification/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Notification> getEvent(@PathVariable int id) {
        return new ResponseEntity<Notification>(notificationRepository.findOne(id), HttpStatus.OK);

    }

}
