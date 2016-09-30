package com.github.solairerove.woodstock.utils;

import com.github.solairerove.woodstock.domain.Profile;
import com.github.solairerove.woodstock.domain.Ticket;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Component;

/**
 * Created by krivitski-no on 9/30/16.
 */
@Component
public class EntityUtils {
    private static final int MAX_STRING_LENGTH = 25;

    private static String getRandomString() {
        return RandomStringUtils.random(MAX_STRING_LENGTH);
    }

    public static Profile generateProfile() {
        return new Profile(getRandomString(), getRandomString());
    }

    public static Ticket generateTicket() {
        return new Ticket(getRandomString());
    }
}
