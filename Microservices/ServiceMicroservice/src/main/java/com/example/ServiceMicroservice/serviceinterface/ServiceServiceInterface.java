package com.example.ServiceMicroservice.serviceinterface;

import com.example.ServiceMicroservice.entity.Services;

import java.util.List;

public interface ServiceServiceInterface {

    public Services addService(Services services);

    public List<Services> getServicesOfUser(Long userId);
}
