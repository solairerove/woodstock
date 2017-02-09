package com.github.solairerove.woodstock.service.impl;

import com.github.solairerove.woodstock.domain.Domain;
import com.github.solairerove.woodstock.dto.DomainDTO;
import com.github.solairerove.woodstock.repository.DomainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DomainServiceImpl {

    private final DomainRepository domainRepository;

    @Autowired
    public DomainServiceImpl(DomainRepository domainRepository) {
        this.domainRepository = domainRepository;
    }

    public Domain create(DomainDTO domainDTO) {
        Domain domain = new Domain();
        domain.setFirstField(domainDTO.getFirstField());
        domain.setLastField(domainDTO.getLastField());
        this.domainRepository.save(domain);

        return domain;
    }

    public List<Domain> getAll() {
        return this.domainRepository.findAll();
    }
}
