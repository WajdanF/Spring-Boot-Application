package com.pularsight.conferencedemo.controllers;


import com.pularsight.conferencedemo.models.Session;
import com.pularsight.conferencedemo.models.Speaker;
import com.pularsight.conferencedemo.repositories.SpeakerRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/speakers")
public class SpeakersController {

    @Autowired
    private SpeakerRepository speakerRepository;

    @GetMapping
    public List<Speaker> list(){
        return speakerRepository.findAll();
    }

    @GetMapping
    @RequestMapping("{id}")
    public Speaker get(@PathVariable Long id){
        return speakerRepository.getById(id);
    }

    @PostMapping
    public Speaker create(@RequestBody final Speaker speaker){
        return speakerRepository.saveAndFlush(speaker);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id){
        speakerRepository.deleteById(id);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)

    public Speaker put(@PathVariable Long id, @RequestBody Speaker speaker) {

        Speaker existingSpeaker = speakerRepository.getById(id);
        BeanUtils.copyProperties(speaker,existingSpeaker, "speaker_id");

        return speakerRepository.saveAndFlush(existingSpeaker);
    }
    }

