package com.codegym.furama.service;


import com.codegym.furama.entity.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IServiceService {
    void save(Service service);

    Page<Service> findAll(Pageable pageable);

    Iterable<Service> findAll();

    Page<Service> findAllByServiceNameContainingAndStandardRoomContaining(String name, String standardRoom, Pageable pageable);

    Optional<Service> findById(String id);

    void remove(String id);
}
