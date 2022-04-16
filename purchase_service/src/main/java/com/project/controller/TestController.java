package com.project.controller;

import com.project.config.CommonConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class TestController {

    @Autowired
    CommonConfig commonConfig;
    
    @GetMapping("/")
    public String index(){
        return "version = " + commonConfig.getVersion();
    }

}
