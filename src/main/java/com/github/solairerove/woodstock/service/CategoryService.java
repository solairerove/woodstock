package com.github.solairerove.woodstock.service;

import com.github.solairerove.woodstock.domain.Category;
import com.github.solairerove.woodstock.dto.CategoryDTO;

public interface CategoryService {

    Category create(Long unitId, CategoryDTO categoryDTO);

    Category get(Long unitId, Long categoryId);

    Iterable<Category> getAll(Long unitId, Integer limit);
}
