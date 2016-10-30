package com.github.solairerove.woodstock.service.impl;

import com.github.solairerove.woodstock.domain.Category;
import com.github.solairerove.woodstock.domain.Unit;
import com.github.solairerove.woodstock.dto.CategoryDTO;
import com.github.solairerove.woodstock.repository.CategoryRepository;
import com.github.solairerove.woodstock.repository.UnitRepository;
import com.github.solairerove.woodstock.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final UnitRepository unitRepository;

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(UnitRepository unitRepository, CategoryRepository categoryRepository) {
        this.unitRepository = unitRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Category create(Long unitId, CategoryDTO categoryDTO) {
        Category category = new Category();
        category.setName(categoryDTO.getName());

        Unit unit = unitRepository.findOne(unitId);
        unit.getCategories().add(category);
        unitRepository.save(unit);

        return category;
    }

    @Override
    public Category get(Long unitId, Long categoryId) {
        return categoryRepository.getCategoryThatHasInUnitFromId(unitId, categoryId);
    }

    @Override
    public Iterable<Category> getAll(Long unitId) {
        return categoryRepository.getCategoriesThatHasInUnitFromId(unitId);
    }
}
