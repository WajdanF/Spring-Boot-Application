package com.pularsight.conferencedemo.controllers;


import com.pularsight.conferencedemo.models.Session;
import com.pularsight.conferencedemo.repositories.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController //This will respond to payload incoming and outgoing as JSON endpoints
@RequestMapping("/api/v1/sessions") //Tells the router what mapping URL will look like, so here all requests will be send to this controllers
public class SessionsController {

    @Autowired //This will inject the SessionRepository into the SessionsController class so that it can be used in the controller methods (creates an instance or uses previous one)
    private SessionRepository sessionRepository;

    //LIST END POINT
    @GetMapping //This is a GET request
    public List<Session> list(){ //returns all of the sessions
        return sessionRepository.findAll(); //Queries all of the sessions from the database and returns them in which JPA will convert them to JSON and send back to the client

    }

    @GetMapping//Get Request which uses the GET verb
    @RequestMapping("{id}") //This is an addition to the RequestMapping above which only gives a general link and this gives a more concrete addition of an ID on the URL
    public Optional<Session> get(@PathVariable Long id){ //@PathVariable is getting that {id} off of the URL and injecting it into id variable automatically
        return sessionRepository.findById(id);
    }



}
