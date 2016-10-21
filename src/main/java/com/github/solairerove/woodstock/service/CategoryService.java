package com.github.solairerove.woodstock.service;

import com.github.solairerove.woodstock.domain.Category;
import com.github.solairerove.woodstock.dto.CategoryDTO;

public interface CategoryService {

    Category create(CategoryDTO categoryDTO);

    Category get(Long id);

    Iterable<Category> deleteAll();
}
