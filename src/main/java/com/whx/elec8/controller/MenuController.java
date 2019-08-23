package com.whx.elec8.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("menu")
public class MenuController {
    @RequestMapping("/{path}")
    public String path(@PathVariable("path") String path){
        System.out.println("path = " + path);
        return "menu/"+path;
    }
}
