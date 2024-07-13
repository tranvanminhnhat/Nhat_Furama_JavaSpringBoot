package com.codegym.furama.repository;

import com.codegym.furama.entity.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ServiceRepository extends PagingAndSortingRepository<Service, String> {
    Page<Service> findAllByServiceNameContainingAndStandardRoomContaining(String name, String standardRoom, Pageable pageable);
}
