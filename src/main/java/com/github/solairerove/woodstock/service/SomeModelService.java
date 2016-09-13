package com.github.solairerove.woodstock.service;

import com.github.solairerove.woodstock.domain.SomeModel;
import com.github.solairerove.woodstock.utils.ModelUtils;
import org.springframework.stereotype.Service;

/**
 * Created by krivitski-no on 9/13/16.
 */
@Service
public class SomeModelService{

    public SomeModel getRandomModel() {
        return ModelUtils.generateSomeModel();
    }
}
