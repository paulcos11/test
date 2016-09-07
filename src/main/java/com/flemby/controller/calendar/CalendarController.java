package com.flemby.controller.calendar;

import com.flemby.entity.Calendar;
import com.flemby.repository.CalendarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;

/**
 * Created by Paul on 31/08/2016.
 */
@RestController
public class CalendarController {

    @Autowired
    private CalendarRepository calendarRepository;

    @RequestMapping(value = "/calendarMonth/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Calendar> getCalendarMonth(@PathVariable int id) throws ParseException {
        return new ResponseEntity<Calendar>(calendarRepository.findOne(id), HttpStatus.OK);
    }
}
