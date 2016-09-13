package com.github.solairerove.woodstock.utils;

import com.github.solairerove.woodstock.domain.SomeModel;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Component;

/**
 * Created by krivitski-no on 9/13/16.
 */
@Component
public class ModelUtils {
    private static final int MAX_STRING_LENGTH = 25;

    private static String getRandomString(int length) {
        return RandomStringUtils.random(length, true, true);
    }

    public static SomeModel generateSomeModel() {
        return new SomeModel(
                getRandomString(MAX_STRING_LENGTH),
                getRandomString(MAX_STRING_LENGTH),
                getRandomString(MAX_STRING_LENGTH),
                getRandomString(MAX_STRING_LENGTH)
        );
    }
}
