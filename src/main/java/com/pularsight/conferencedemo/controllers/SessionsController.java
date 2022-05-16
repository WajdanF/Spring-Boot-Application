package com.pularsight.conferencedemo.controllers;


import com.pularsight.conferencedemo.models.Session;
import com.pularsight.conferencedemo.repositories.SessionRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
//A FULL CRUD (create, read, update, delete) CONTROLLER FOR SESSIONS
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
    public Session get(@PathVariable Long id){ //@PathVariable is getting that {id} off of the URL and injecting it into id variable automatically
        return sessionRepository.getById(id);
    }

    @PostMapping //This is a POST (creation) request which is used to create a new session in the database (POST is a HTTP verb)
    public Session create(@RequestBody final Session session){ //@RequestBody is used to get the JSON payload from the client and convert it to a Session object
        return sessionRepository.saveAndFlush(session); //Saves the session to the database and returns the session object
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE) //This is a DELETE request which is used to delete a session from the database, which has a specific ID and the method is also specifeid
    public void delete (@PathVariable Long id){ //@PathVariable is getting that {id} off of the URL and injecting it into id variable automatically

        //Also need to check for children records in the database before deleting which is not done here
        sessionRepository.deleteById(id);//Deletes the session from the database
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT) //This is a PUT request which is used to update a session in the database, which has a specific ID and the method is also specifeid
    public Session put(@PathVariable Long id, @RequestBody Session session){ //@PathVariable is getting that {id} off of the URL and injecting it into id variable automatically
        //Because this is a PUT request, we expect all attriutes to be passed in. a PATCH would only need a portion of the attributes to be passed in

        //TODO: Add validation that all attributes are passed in, otheerwise return an error (400 bad payload)

        Session existingSession = sessionRepository.getById(id); //Gets the session from the database with the ID passed in (existing one)
        BeanUtils.copyProperties(session,existingSession, "session_id"); //Copies the incoming session into th existingSession object and ignores the ID (because its the primary key and we don't want to change that)

        return sessionRepository.saveAndFlush(existingSession); //Saves the session to the database and returns the session object (with the updated attributes)

    }

}
