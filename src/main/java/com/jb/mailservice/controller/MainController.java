package com.jb.mailservice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/removed")
    public String removed(){
        return "removed";
    }

    @GetMapping("/errorRemoving")
    public String errorRemoving(){
        return "errorRemoving";
    }
}
