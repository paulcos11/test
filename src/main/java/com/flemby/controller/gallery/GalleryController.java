package com.flemby.controller.gallery;

import com.flemby.entity.Event;
import com.flemby.entity.Item;
import com.flemby.repository.EventRepository;
import com.flemby.repository.IndexRepository;
import com.flemby.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Paul on 29/08/2016.
 */

@RestController
public class GalleryController {

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private ItemService itemService;

    @Autowired
    private IndexRepository indexRepository;

    private static int counterOne = 0;
    private static int counterTwo = 0;

    @RequestMapping(value = "/previousEventsGallery", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Event>> gallery(){
        return new ResponseEntity<List<Event>>(eventRepository.findAllByOrderByPublishedDateDesc(), HttpStatus.OK);
    }


    @RequestMapping(value = "/itemEventsGallery/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Item>> getItem(@PathVariable int id){
        return new ResponseEntity<List<Item>>(eventRepository.findOne(id).getItems(), HttpStatus.OK);
    }

    @RequestMapping(value = "/items/image.html")
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        System.out.println("imageTEST " + id);
        byte[] image = itemService.loadImage(id);
        ServletOutputStream outputStream = response.getOutputStream();
        outputStream.write(image);
        outputStream.close();
    }

    @RequestMapping(value = "/items/gallery/one/image.html")
    protected void doPostGalleryOne(HttpServletRequest request,
                                    HttpServletResponse response) throws ServletException, IOException {

        if (counterOne == 3)
            counterOne = 0;

        int id = Integer.parseInt(request.getParameter("id"));
        Event event = eventRepository.findOne(id);
        System.out.println("imageTEST " + counterOne);
        List<Item> items = event.getItems();

        byte[] image = itemService.loadImage(items.get(counterOne).getId());
        counterOne++;
        ServletOutputStream outputStream = response.getOutputStream();
        outputStream.write(image);
        outputStream.close();


    }

    @RequestMapping(value = "/items/gallery/two/image.html")
    protected void doPostGalleryTwo(HttpServletRequest request,
                                    HttpServletResponse response) throws ServletException, IOException {

        if (counterTwo == 3)
            counterTwo = 0;

        int id = Integer.parseInt(request.getParameter("id"));
        Event event = eventRepository.findOne(id);
        System.out.println("imageTEST2 " + counterTwo);
        List<Item> items = event.getItems();

        byte[] image = itemService.loadImage(items.get(counterTwo).getId());
        counterTwo++;
        ServletOutputStream outputStream = response.getOutputStream();
        outputStream.write(image);
        outputStream.close();


    }
}
