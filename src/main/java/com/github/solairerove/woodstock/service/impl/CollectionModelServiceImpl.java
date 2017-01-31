package com.github.solairerove.woodstock.service.impl;

import com.github.solairerove.woodstock.domain.CollectionModel;
import com.github.solairerove.woodstock.domain.DomainModel;
import com.github.solairerove.woodstock.dto.CollectionModelDTO;
import com.github.solairerove.woodstock.repository.CollectionModelRepository;
import com.github.solairerove.woodstock.repository.DomainModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class CollectionModelServiceImpl {

    private final DomainModelRepository domainModelRepository;

    private final CollectionModelRepository collectionModelRepository;

    @Autowired
    public CollectionModelServiceImpl(DomainModelRepository domainModelRepository, CollectionModelRepository collectionModelRepository) {
        this.domainModelRepository = domainModelRepository;
        this.collectionModelRepository = collectionModelRepository;
    }

    public CollectionModel create(String domainId, CollectionModelDTO dto) {

        DomainModel domainModel = domainModelRepository.findOne(domainId);
        CollectionModel collectionModel = new CollectionModel(dto.getSomeField());
        domainModel.getCollectionModels().add(collectionModel);
        domainModelRepository.save(domainModel);

        return collectionModel;
    }

    public Collection<CollectionModel> getAll(String domainId) {
        return domainModelRepository.findOne(domainId).getCollectionModels();
    }
}
