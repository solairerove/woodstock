package com.github.solairerove.woodstock.service.common;

import com.github.solairerove.woodstock.domain.BaseEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.List;

/**
 * Created by krivitski-no on 10/8/16.
 */
public interface GenericService<T extends BaseEntity, I extends Serializable> {
    T get(I i);

    I delete(I i);

    List<T> deleteAll();

    Page<T> findAll(Pageable pageable);
}
