package com.github.solairerove.woodstock.service;

import com.github.solairerove.woodstock.domain.BaseEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.List;

/**
 * Created by krivitski-no on 10/7/16.
 */
public interface BaseService<T extends BaseEntity, S extends Serializable> {
    String create(S s);

    T get(String id);

    String update(String id, S s);

    String delete(String id);

    List<T> deleteAll();

    Page<T> findAll(Pageable pageable);
}
