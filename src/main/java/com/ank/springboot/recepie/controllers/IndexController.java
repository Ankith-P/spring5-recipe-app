package com.ank.springboot.recepie.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @RequestMapping({"","/","/index","/index.html"})
    public String getIndex()
    {
        System.out.println("Printing values for test DJ ank");
        return "index";
    }

}
