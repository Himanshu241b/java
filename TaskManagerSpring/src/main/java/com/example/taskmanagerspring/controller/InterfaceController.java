package com.example.taskmanagerspring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InterfaceController {
    @GetMapping("/")
    public String getIndex() {
        return "index";
    }
}
