//package com.github.solairerove.woodstock.utils;
//
//import com.github.solairerove.woodstock.domain.Module;
//import com.github.solairerove.woodstock.domain.Profile;
//import com.github.solairerove.woodstock.domain.Task;
//import com.github.solairerove.woodstock.domain.Ticket;
//import com.github.solairerove.woodstock.dto.ModuleDTO;
//import com.github.solairerove.woodstock.dto.ProfileDTO;
//import com.github.solairerove.woodstock.dto.TaskDTO;
//import com.github.solairerove.woodstock.dto.TicketDTO;
//import org.apache.commons.lang3.RandomStringUtils;
//import org.apache.commons.lang3.RandomUtils;
//import org.springframework.stereotype.Component;
//
//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.List;
//
//@Component
//public class EntityUtils {
//
//    public static final int NUMBER_OF_ENTITIES_IN_COLLECTION = 15;
//
//    public static final int MAX_STRING_LENGTH = 25;
//
//    public static String getRandomString() {
//        return RandomStringUtils.random(MAX_STRING_LENGTH, true, true);
//    }
//
//    public static boolean getRandomBoolean() {
//        return RandomUtils.nextBoolean();
//    }
//
//    public static Profile generateProfile() {
//        Profile profile = new Profile();
//        profile.setFirstName(getRandomString());
//        profile.setLastName(getRandomString());
//
//        return profile;
//    }
//
//    public static ProfileDTO generateProfileDTO() {
//        ProfileDTO profileDTO = new ProfileDTO();
//        profileDTO.setFirstName(getRandomString());
//        profileDTO.setLastName(getRandomString());
//
//        return profileDTO;
//    }
//
//    public static Iterable<Profile> generateProfileCollection() {
//        Collection<Profile> profiles = new ArrayList<>();
//        for (int i = 0; i < NUMBER_OF_ENTITIES_IN_COLLECTION; i++) {
//            profiles.add(generateProfile());
//        }
//        return profiles;
//    }
//
//    public static Ticket generateTicket() {
//        Ticket ticket = new Ticket();
//        ticket.setValue(getRandomString());
//
//        return ticket;
//    }
//
//    public static TicketDTO generateTicketDTO() {
//        TicketDTO ticketDTO = new TicketDTO();
//        ticketDTO.setValue(getRandomString());
//
//        return ticketDTO;
//    }
//
//    public static List<Ticket> generateTicketCollection() {
//        List<Ticket> tickets = new ArrayList<>();
//        for (int i = 0; i < NUMBER_OF_ENTITIES_IN_COLLECTION; i++) {
//            tickets.add(generateTicket());
//        }
//        return tickets;
//    }
//
//    public static Task generateTask() {
//        Task task = new Task();
//        task.setQuestion(getRandomString());
//
//        return task;
//    }
//
//    public static TaskDTO generateTaskDTO() {
//        TaskDTO taskDTO = new TaskDTO();
//        taskDTO.setQuestion(getRandomString());
//
//        return taskDTO;
//    }
//
//    public static Iterable<Task> generateTaskCollection() {
//        Collection<Task> tasks = new ArrayList<>();
//        for (int i = 0; i < NUMBER_OF_ENTITIES_IN_COLLECTION; i++) {
//            tasks.add(generateTask());
//        }
//
//        return tasks;
//    }
//
//    public static Module generateModule() {
//        Module module = new Module();
//        module.setName(getRandomString());
//
//        return module;
//    }
//
//    public static ModuleDTO generateModuleDTO() {
//        ModuleDTO moduleDTO = new ModuleDTO();
//        moduleDTO.setName(getRandomString());
//
//        return moduleDTO;
//    }
//
//    public static Iterable<Module> generateModuleCollection() {
//        Collection<Module> modules = new ArrayList<>();
//        for (int i = 0; i < NUMBER_OF_ENTITIES_IN_COLLECTION; i++) {
//            modules.add(generateModule());
//        }
//
//        return modules;
//    }
//}
