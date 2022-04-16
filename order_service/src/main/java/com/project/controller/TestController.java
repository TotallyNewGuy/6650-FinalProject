package com.project.controller;

import com.project.config.RefreshConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class TestController {

    @Autowired
    RefreshConfig commonConfig;
    
    @GetMapping
    public String index(){
        return "version = " + commonConfig.getVersion();
    }

}
