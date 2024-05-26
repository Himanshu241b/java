package com.example.ServiceMicroservice.serviceImpl;

import com.example.ServiceMicroservice.entity.Services;
import com.example.ServiceMicroservice.repository.ServicesRepository;
import com.example.ServiceMicroservice.serviceinterface.ServiceServiceInterface;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ServicesImpl implements ServiceServiceInterface {

    private final ServicesRepository servicesRepository;

    ServicesImpl(ServicesRepository servicesRepository){
        this.servicesRepository = servicesRepository;
    }

    public Services addService(Services service) {
        Services newServices = new Services();
        newServices.setServiceName(service.getServiceName());
        newServices.setUserId(service.getUserId());

        return servicesRepository.save(newServices);
    }

    public List<Services> getServicesOfUser(Long userId) {
        return servicesRepository.findByUserId(userId);
    }
}
