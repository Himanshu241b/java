package com.example.StripePayments.ViewController;

import lombok.Getter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StripeViewController {

    @GetMapping("/")
    public String index(){
        return "stripe";
    }
}
