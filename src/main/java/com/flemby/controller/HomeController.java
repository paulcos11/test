package com.flemby.controller;

import com.flemby.entity.Index;
import com.flemby.repository.IndexRepository;
import com.flemby.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Paul on 19/08/2016.
 */
@RestController
public class HomeController {

    @Autowired
    private IndexRepository indexRepository;

    @Autowired
    private EventService eventService;


    @RequestMapping(value = "/resource", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Index> getIndex() {
        return new ResponseEntity<Index>(indexRepository.findOne(1), HttpStatus.OK);
    }
//
//    @RequestMapping("/user")
//    public Principal user(Principal user) {
//        return user;
//    }

}
