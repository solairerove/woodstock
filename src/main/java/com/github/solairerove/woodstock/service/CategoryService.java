package com.github.solairerove.woodstock.service;

import com.github.solairerove.woodstock.domain.Category;
import com.github.solairerove.woodstock.dto.CategoryDTO;

/**
 * Created by krivitski-no on 10/14/16.
 */
public interface CategoryService {

    Category create(CategoryDTO categoryDTO);

    Category get(Long id);
}
