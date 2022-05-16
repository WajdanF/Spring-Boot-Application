package com.pularsight.conferencedemo.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class HomeController {

    @Value("${app.version}") // value is read from application.properties file
    private String appVersion;

    @GetMapping
    @RequestMapping("/")
    public Map getStatus() {

        Map map = new HashMap<String,String>();
        map.put("app-version", appVersion);
        return map;
    }
}
