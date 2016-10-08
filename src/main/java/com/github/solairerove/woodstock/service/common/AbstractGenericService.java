package com.github.solairerove.woodstock.service.common;

import com.github.solairerove.woodstock.domain.BaseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

/**
 * Created by krivitski-no on 10/8/16.
 */
@Service
public abstract class AbstractGenericService<T extends BaseEntity, REPO extends MongoRepository<T, ID>, ID extends Serializable>
        implements GenericService<T, ID> {
    @Autowired
    protected REPO repo;

    @Override
    public T get(ID id) {
        return repo.findOne(id);
    }

    @Override
    public ID delete(ID id) {
        repo.delete(id);
        return id;
    }

    @Override
    public List<T> deleteAll() {
        List<T> list = repo.findAll();
        repo.deleteAll();
        return list;
    }

    @Override
    public Page<T> findAll(Pageable pageable) {
        return repo.findAll(pageable);
    }
}
