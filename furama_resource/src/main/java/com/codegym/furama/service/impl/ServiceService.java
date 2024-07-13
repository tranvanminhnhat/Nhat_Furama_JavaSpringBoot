package com.codegym.furama.service.impl;

import com.codegym.furama.repository.ServiceRepository;
import com.codegym.furama.service.IServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ServiceService implements IServiceService {
    @Autowired
    ServiceRepository serviceRepository;

    @Override
    public void save(com.codegym.furama.entity.Service service) {
        serviceRepository.save(service);
    }

    @Override
    public Page<com.codegym.furama.entity.Service> findAll(Pageable pageable) {
        return serviceRepository.findAll(pageable);
    }

    @Override
    public Iterable<com.codegym.furama.entity.Service> findAll() {
        return serviceRepository.findAll();
    }

    @Override
    public Page<com.codegym.furama.entity.Service> findAllByServiceNameContainingAndStandardRoomContaining(String name, String standardRoom, Pageable pageable) {
        return serviceRepository.findAllByServiceNameContainingAndStandardRoomContaining(name, standardRoom, pageable);
    }

    @Override
    public Optional<com.codegym.furama.entity.Service> findById(String id) {
        return serviceRepository.findById(id);
    }

    @Override
    public void remove(String id) {
        serviceRepository.deleteById(id);
    }
}
