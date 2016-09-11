package com.flemby.controller.event;

import com.flemby.entity.Event;
import com.flemby.entity.Item;
import com.flemby.repository.EventRepository;
import com.flemby.repository.ItemRepository;
import com.flemby.service.EventService;
import com.flemby.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by Paul on 24/08/2016.
 */
@RestController
public class EventController {

    @Autowired
    private EventService eventService;

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private ItemService itemService;

    @RequestMapping(value = "/updateUpcomingEvent/{id}", method = RequestMethod.POST)
    public ResponseEntity<Event> updateUpcomingEvent(@RequestParam("type") String type,
                                                     @RequestParam("name") String name,
                                                     @RequestParam("location") String location,
                                                     @RequestParam("link") String link,
                                                     @RequestParam("text") String text,
                                                     @RequestParam("publishedDate") String publishedDate,
                                                     @PathVariable int id) throws IOException, ParseException {


        Event event = eventService.findOne(id);
        event.setType(type);
        event.setName(name);
        event.setLocation(location);
        event.setLink(link);
        event.setText(text);
        System.out.println("Date " + publishedDate);
        String dateStr = publishedDate;
        DateFormat format1 = new SimpleDateFormat("dd/MM/yyyy");
        Date date;
        date = format1.parse(dateStr);
        event.setPublishedDate(date);
        event.setHasImage(false);
        eventRepository.save(event);
        return new ResponseEntity<Event>(event, HttpStatus.OK);
    }

    @RequestMapping(value = "/items/one/image.html")
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));

        Event event = eventRepository.findOne(id);
//        event.setHasImage(true);
        eventRepository.save(event);

        List<Item> items = event.getItems();

        System.out.println("imageTEST " + id);

        byte[] image = itemService.loadImage(items.get(0).getId());
        ServletOutputStream outputStream = response.getOutputStream();
        outputStream.write(image);
        outputStream.close();
    }

    @RequestMapping(value = "/items/two/image.html")
    protected void doPostTwo(HttpServletRequest request,
                             HttpServletResponse response) throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));

        Event event = eventRepository.findOne(id);
        List<Item> items = event.getItems();

        System.out.println("imageTEST " + id);

        byte[] image = itemService.loadImage(items.get(1).getId());
        ServletOutputStream outputStream = response.getOutputStream();
        outputStream.write(image);
        outputStream.close();
    }

    @RequestMapping(value = "/items/three/image.html")
    protected void doPostThree(HttpServletRequest request,
                               HttpServletResponse response) throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));

        Event event = eventRepository.findOne(id);
        List<Item> items = event.getItems();


        System.out.println("imageTEST " + id);

        byte[] image = itemService.loadImage(items.get(2).getId());
        ServletOutputStream outputStream = response.getOutputStream();
        outputStream.write(image);
        outputStream.close();
    }

    @RequestMapping(value = "/item/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Item>> getItem(@PathVariable int id) {
        Event event = eventService.findOne(id);
        List<Item> items = event.getItems();
        return new ResponseEntity<List<Item>>(items, HttpStatus.OK);

    }


    @RequestMapping(value = "/updateEvent/{id}", method = RequestMethod.POST)
    public ResponseEntity<Event> uploadFiles(@RequestParam("text") String text,
                                             @RequestParam("story") String story,
                                             @RequestParam("file") MultipartFile file,
                                             @RequestParam("file2") MultipartFile file2,
                                             @RequestParam("file3") MultipartFile file3,
                                             @PathVariable int id) throws IOException {


        Event event = eventService.findOne(id);
        event.setText(text);
        event.setStory(story);

        List<Item> items = event.getItems();

        if (items.size() == 0) {

            byte[] bytes = file.getBytes();
            Item item1 = new Item();
            item1.setImage(bytes);
            item1.setEvent(event);
            itemRepository.save(item1);
            items.add(itemRepository.findOne(item1.getId()));

            byte[] bytes1 = file2.getBytes();

            Item item2 = new Item();
            item2.setImage(bytes1);
            item2.setEvent(event);
            itemRepository.save(item2);
            items.add(itemRepository.findOne(item2.getId()));

            byte[] bytes2 = file3.getBytes();
            Item item3 = new Item();
            item3.setImage(bytes2);
            item3.setEvent(event);
            itemRepository.save(item3);
            items.add(itemRepository.findOne(item3.getId()));
            event.setItems(items);

        } else {

            List<Item> itemList = new ArrayList<>();

            int newId = items.get(0).getId();
            itemRepository.delete(items.get(0).getId());
            byte[] bytes = file.getBytes();
            Item item1 = new Item();
            item1.setId(newId);
            item1.setImage(bytes);
            item1.setEvent(event);
            itemRepository.save(item1);
            itemList.add(item1);


            int newId2 = items.get(1).getId();
            itemRepository.delete(items.get(1).getId());
            byte[] bytes1 = file2.getBytes();
            Item item2 = new Item();
            item2.setId(newId2);
            item2.setImage(bytes1);
            item2.setEvent(event);
            itemRepository.save(item2);
            itemList.add(item2);

            int newId3 = items.get(2).getId();
            itemRepository.delete(items.get(2).getId());
            byte[] bytes2 = file3.getBytes();
            Item item3 = new Item();
            item3.setId(newId3);
            item3.setImage(bytes2);
            item3.setEvent(event);
            itemRepository.save(item3);
            itemList.add(item3);
            event.setItems(itemList);

        }
        event.setHasImage(true);
        eventRepository.save(event);
        System.out.println("Passssssssssssssssssssssssssssssssssssssssssssss");
        return new ResponseEntity<Event>(event, HttpStatus.OK);
    }


    @RequestMapping(value = "/schoolEvent", method = RequestMethod.POST)
    public ResponseEntity<Event> updateSchoolEvent(@RequestBody Event event, UriComponentsBuilder ucBuilder) {

        eventRepository.save(event);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/user/{id}").buildAndExpand(event.getId()).toUri());
        return new ResponseEntity<Event>(event, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/events", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Event>> getPreviousEvents() throws ParseException {

        Date date;
        Date date2 = Calendar.getInstance().getTime();
        DateFormat format1 = new SimpleDateFormat("dd/MM/yyyy");
        String dateStr = format1.format(date2);
        date = format1.parse(dateStr);
        List<Event> events = eventService.findBeforeTodaysDate(date);
        return new ResponseEntity<List<Event>>(events, HttpStatus.OK);
    }

    @RequestMapping(value = "/event/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Event> getEvent(@PathVariable int id) {
        return new ResponseEntity<Event>(eventService.findOne(id), HttpStatus.OK);

    }

    @RequestMapping(value = "/schoolEvents", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Event>> getSchoolEvents() throws ParseException {
        String event = "School Activity";
        return new ResponseEntity<List<Event>>(eventService.findByType(event), HttpStatus.OK);
    }

    @RequestMapping(value = "/seniorClassEvents", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Event>> getSeniorEvents() throws ParseException {
        String event = "Senior Class Activity";
        return new ResponseEntity<List<Event>>(eventService.findByType(event), HttpStatus.OK);
    }

    @RequestMapping(value = "/juniorClassEvents", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<Event>> getJuniorEvents() throws ParseException {
        String event = "Junior Class Activity";
        return new ResponseEntity<List<Event>>(eventService.findByType(event), HttpStatus.OK);
    }
}