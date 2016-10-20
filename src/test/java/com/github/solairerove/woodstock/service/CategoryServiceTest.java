package com.github.solairerove.woodstock.service;

import com.github.solairerove.woodstock.Application;
import com.github.solairerove.woodstock.domain.Category;
import com.github.solairerove.woodstock.dto.CategoryDTO;
import com.github.solairerove.woodstock.repository.CategoryRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import static com.github.solairerove.woodstock.utils.EntityUtils.generateCategory;
import static com.github.solairerove.woodstock.utils.EntityUtils.generateCategoryCollection;
import static com.github.solairerove.woodstock.utils.EntityUtils.generateCategoryDTO;
import static org.junit.Assert.assertEquals;

/**
 * Created by krivitski-no on 10/20/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
@Transactional
public class CategoryServiceTest {

    @Autowired
    private CategoryRepository repository;

    @Autowired
    private CategoryService service;

    @Before
    public void setUp() {
        repository.deleteAll();
    }

    @After
    public void clear() {
        repository.deleteAll();
    }

    @Test
    public void createCategoryTest() {
        CategoryDTO saved = generateCategoryDTO();
        Long id = service.create(saved).getId();

        assertEquals(saved.getName(), repository.findOne(id).getName());
    }

    @Test
    public void getCategoryTest() {
        Category saved = generateCategory();
        repository.save(saved);

        assertEquals(saved, service.get(saved.getId()));
    }

    @Test
    public void deleteAdd() {
        repository.save(generateCategoryCollection());

        service.deleteAll();

        assertEquals(0, repository.count());
    }
}
