package com.flemby.controller;

import com.flemby.entity.Index;
import com.flemby.entity.Item;
import com.flemby.repository.IndexRepository;
import com.flemby.repository.ItemRepository;
import com.flemby.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Paul on 19/08/2016.
 */
@RestController
public class HomeController {

    @Autowired
    private IndexRepository indexRepository;

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private ItemService itemService;


    @RequestMapping(value = "/resource", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Index> getIndex() {
        return new ResponseEntity<Index>(indexRepository.findOne(1), HttpStatus.OK);
    }

    @RequestMapping(value = "/updateHome/{id}", method = RequestMethod.POST)
    public ResponseEntity<Index> uploadHomePage(@RequestParam("text") String text,
                                             @RequestParam("file") MultipartFile file,
                                             @RequestParam("file2") MultipartFile file2,
                                             @RequestParam("file3") MultipartFile file3,
                                             @PathVariable int id) throws IOException {


        Index index = indexRepository.findOne(id);
        index.setText(text);

        List<Item> items = index.getItems();


        if (items.size() == 0) {

            byte[] bytes = file.getBytes();
            Item item1 = new Item();
            item1.setImage(bytes);
            item1.setIndex(index);
            itemRepository.save(item1);
            items.add(itemRepository.findOne(item1.getId()));

            byte[] bytes1 = file2.getBytes();

            Item item2 = new Item();
            item2.setImage(bytes1);
            item2.setIndex(index);
            itemRepository.save(item2);
            items.add(itemRepository.findOne(item2.getId()));

            byte[] bytes2 = file3.getBytes();
            Item item3 = new Item();
            item3.setImage(bytes2);
            item3.setIndex(index);
            itemRepository.save(item3);
            items.add(itemRepository.findOne(item3.getId()));

            index.setItems(items);



        } else {

            List<Item> itemList = new ArrayList<>();

            int newId = items.get(0).getId();
            itemRepository.delete(items.get(0).getId());
            byte[] bytes = file.getBytes();
            Item item1 = new Item();
            item1.setId(newId);
            item1.setImage(bytes);
            item1.setIndex(index);
            itemRepository.save(item1);
            itemList.add(item1);


            int newId2 = items.get(1).getId();
            itemRepository.delete(items.get(1).getId());
            byte[] bytes1 = file2.getBytes();
            Item item2 = new Item();
            item2.setId(newId2);
            item2.setImage(bytes1);
            item2.setIndex(index);
            itemRepository.save(item2);
            itemList.add(item2);

            int newId3 = items.get(2).getId();
            itemRepository.delete(items.get(2).getId());
            byte[] bytes2 = file3.getBytes();
            Item item3 = new Item();
            item3.setId(newId3);
            item3.setImage(bytes2);
            item3.setIndex(index);
            itemRepository.save(item3);
            itemList.add(item3);
            index.setItems(itemList);
            System.out.println(id + " test2");
        }
        indexRepository.save(index);
        System.out.println("Passssssssssssssssssssssssssssssssssssssssssssss " + indexRepository.findOne(1).getItems().get(0).getId());
        return new ResponseEntity<Index>(index, HttpStatus.OK);
    }

    @RequestMapping(value = "/items/four/image.html")
    protected void doPostFour(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        Index index = indexRepository.findOne(id);
        List<Item> items = index.getItems();
        System.out.println("itemsSize " + items.size());
        byte[] image = itemService.loadImage(items.get(0).getId());
        ServletOutputStream outputStream = response.getOutputStream();
        outputStream.write(image);
        outputStream.close();
    }

    @RequestMapping(value = "/items/five/image.html")
    protected void doPostFive(HttpServletRequest request,
                             HttpServletResponse response) throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        Index index = indexRepository.findOne(id);
        List<Item> items = index.getItems();
        byte[] image = itemService.loadImage(items.get(1).getId());
        ServletOutputStream outputStream = response.getOutputStream();
        outputStream.write(image);
        outputStream.close();
    }

    @RequestMapping(value = "/items/six/image.html")
    protected void doPostSix(HttpServletRequest request,
                               HttpServletResponse response) throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        Index index = indexRepository.findOne(id);
        List<Item> items = index.getItems();
        byte[] image = itemService.loadImage(items.get(2).getId());
        ServletOutputStream outputStream = response.getOutputStream();
        outputStream.write(image);
        outputStream.close();
    }
}
