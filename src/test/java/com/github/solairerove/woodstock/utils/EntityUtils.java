package com.github.solairerove.woodstock.utils;

import com.github.solairerove.woodstock.domain.Profile;
import com.github.solairerove.woodstock.dto.ProfileDTO;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by krivitski-no on 9/30/16.
 */
@Component
public class EntityUtils {

    public static final int NUMBER_OF_ENTITIES_IN_COLLECTION = 10;

    private static final int MAX_STRING_LENGTH = 25;

    public static String getRandomString() {
        return RandomStringUtils.random(MAX_STRING_LENGTH, true, true);
    }

    public static Profile generateProfile() {
        return new Profile(getRandomString(), getRandomString());
    }

    public static ProfileDTO generateProfileDTO() {
        return new ProfileDTO(getRandomString(), getRandomString());
    }

    public static Iterable<Profile> generateProfileCollection() {
        Collection<Profile> profiles = new ArrayList<>();
        for (int i = 0; i < NUMBER_OF_ENTITIES_IN_COLLECTION; i++) {
            profiles.add(generateProfile());
        }
        return profiles;
    }

//    public static Ticket generateTicket() {
//        return new Ticket(getRandomString());
//    }
//
//    public static TicketDTO generateTicketDTO() {
//        return new TicketDTO(getRandomString());
//    }
//
//    public static Iterable<Ticket> generateTicketCollection() {
//        Collection<Ticket> tickets = new ArrayList<>();
//        for (int i = 0; i < NUMBER_OF_ENTITIES_IN_COLLECTION; i++) {
//            tickets.add(generateTicket());
//        }
//        return tickets;
//    }
//
//    public static Task generateTask() {
//        return new Task(getRandomString());
//    }
//
//    public static TaskDTO generateTaskDTO() {
//        return new TaskDTO(getRandomString());
//    }
//
//    public static Iterable<Task> generateTaskCollection() {
//        Collection<Task> tasks = new ArrayList<>();
//        for (int i = 0; i < NUMBER_OF_ENTITIES_IN_COLLECTION; i++) {
//            tasks.add(generateTask());
//        }
//        return tasks;
//    }
}
