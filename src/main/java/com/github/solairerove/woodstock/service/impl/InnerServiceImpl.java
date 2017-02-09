package com.github.solairerove.woodstock.service.impl;

import com.github.solairerove.woodstock.domain.Domain;
import com.github.solairerove.woodstock.domain.Inner;
import com.github.solairerove.woodstock.dto.InnerDTO;
import com.github.solairerove.woodstock.repository.DomainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InnerServiceImpl {

    private final DomainRepository domainRepository;

    @Autowired
    public InnerServiceImpl(DomainRepository domainRepository) {
        this.domainRepository = domainRepository;
    }

    public Inner create(String domainId, InnerDTO innerDTO) {
        Inner inner = new Inner();
        inner.setSomeField(innerDTO.getSomeField());

        Domain domain = this.domainRepository.findOne(domainId);
        domain.getInners().add(inner);
        domainRepository.save(domain);

        return inner;
    }

    public List<Inner> getAll(String domainId) {
        return this.domainRepository.findOne(domainId).getInners();
    }
}