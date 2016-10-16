package com.github.solairerove.woodstock.service.impl;

import com.github.solairerove.woodstock.domain.Category;
import com.github.solairerove.woodstock.dto.CategoryDTO;
import com.github.solairerove.woodstock.repository.CategoryRepository;
import com.github.solairerove.woodstock.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by krivitski-no on 10/14/16.
 */
@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository repository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository repository) {
        this.repository = repository;
    }

    @Override
    public Category create(CategoryDTO categoryDTO) {
        Category category = new Category();
        category.setName(categoryDTO.getName());
        return repository.save(category);
    }

    @Override
    public Category get(Long id) {
        return repository.findOne(id);
    }
}
