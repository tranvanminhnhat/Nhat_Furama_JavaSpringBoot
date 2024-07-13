package com.codegym.furama.service;

import com.codegym.furama.entity.AttachService;
import org.springframework.stereotype.Service;


@Service
public interface IAttachServiceService {
    Iterable<AttachService> findAll();
}
