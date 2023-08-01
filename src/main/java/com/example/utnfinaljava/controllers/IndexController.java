package com.example.utnfinaljava.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
    
    @RequestMapping(value = "{path:[^\\.]+}/**")
    public String forward() {
        return "forward:/index.html";
    }
}
