package com.example.ServiceMicroservice.Controller;

import com.example.ServiceMicroservice.entity.Services;
import com.example.ServiceMicroservice.serviceImpl.ServicesImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/service")
public class ServiceController {


    private final ServicesImpl servicesImpl;

    ServiceController(ServicesImpl servicesImpl){
        this.servicesImpl = servicesImpl;
    }

    @PostMapping("")
    public Services addService(@RequestBody Services service) {
        Services newService  = servicesImpl.addService(service);
        return newService;
    }

    @GetMapping("/user/{userId}")
    public List<Services> getServicesOfUser(@PathVariable("userId") Long userId) {
        List<Services> userServices = servicesImpl.getServicesOfUser(userId);
        return userServices;
    }
}
