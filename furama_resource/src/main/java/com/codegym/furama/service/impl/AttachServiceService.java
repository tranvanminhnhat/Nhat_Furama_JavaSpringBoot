package com.codegym.furama.service.impl;

import com.codegym.furama.repository.AttachServiceRepository;
import com.codegym.furama.service.IAttachServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AttachServiceService implements IAttachServiceService {
    @Autowired
    private AttachServiceRepository attachServiceRepository;

    @Override
    public Iterable<com.codegym.furama.entity.AttachService> findAll() {
        return attachServiceRepository.findAll();
    }
}
