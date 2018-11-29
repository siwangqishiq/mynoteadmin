package com.mynote.admin.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WorkController {
    @RequestMapping("/hello")
    public String index() {
        System.out.println("it works");
        return "it works";
    }
}//end class
