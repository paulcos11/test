package com.flemby.service;

import com.flemby.entity.Event;
import com.flemby.entity.User;
import com.flemby.repository.EventRepository;
import com.flemby.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private UserRepository userRepository;

    public List<Event> findAll() {
        return eventRepository.findAll();
    }

    public Event findOne(int id) {
        return eventRepository.findOne(id);
    }

    public Event findOne(Event event) {
        int id = event.getId();
        System.out.println(id);
        return eventRepository.findOne(id);
    }

    public void save(Event event, String name) {
        User user = userRepository.findByName(name);
//        event.setUser(user);
        eventRepository.save(event);
    }

    public List<Event> findByType(String type2) throws ParseException {
        Date date = new Date();
        Date date2 = Calendar.getInstance().getTime();
        DateFormat format1 = new SimpleDateFormat("dd/MM/yyyy");
        String dateStr = format1.format(date2);
        date = format1.parse(dateStr);
        String dateStr2 = "10/01/3000";
        Date date3 = new Date();
        date3 = format1.parse(dateStr2);
        List<Event> byType = eventRepository.findByPublishedDateBetweenOrderByPublishedDateDesc(date,
                date3);
        List<Event> schEvent = new ArrayList<Event>();
        for (Event s : byType) {
            System.out.println("test " + s.getType());
            if (s.getType().equalsIgnoreCase(type2)) {
                schEvent.add(s);
            }
        }
        return schEvent;
    }

    public void delete(int id) {
        eventRepository.delete(id);
    }

    public void findOne(String slideShow) {
        Event event = eventRepository.findBySlideShow(slideShow);
        if (event != null) {
            event.setSlideShow("s");
            eventRepository.save(event);
        }
    }

    public Event findOneWith(String slideShow) {
        Event event = eventRepository.findBySlideShow(slideShow);
        return event;
    }

    public void setEventAsSlideShow(Event event) {
        event.setSlideShow("slideShow");
        eventRepository.save(event);
    }

    public List<Event> findBeforeTodaysDate(Date date1) throws ParseException {
        String dateStr = "10/01/2000";
        DateFormat format1 = new SimpleDateFormat("dd/MM/yyyy");
        Date date;
        date = format1.parse(dateStr);
        return eventRepository.findByPublishedDateBetweenOrderByPublishedDateDesc(date, date1);
    }

}
