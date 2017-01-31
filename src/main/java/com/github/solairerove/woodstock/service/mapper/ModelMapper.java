//package com.github.solairerove.woodstock.service.mapper;
//
//import com.github.solairerove.woodstock.domain.Chapter;
//import com.github.solairerove.woodstock.domain.Module;
//import com.github.solairerove.woodstock.domain.Reference;
//import com.github.solairerove.woodstock.domain.Task;
//import com.github.solairerove.woodstock.domain.Ticket;
//import com.github.solairerove.woodstock.domain.Unit;
//import com.github.solairerove.woodstock.dto.ChapterDTO;
//import com.github.solairerove.woodstock.dto.ModuleDTO;
//import com.github.solairerove.woodstock.dto.ReferenceDTO;
//import com.github.solairerove.woodstock.dto.TaskDTO;
//import com.github.solairerove.woodstock.dto.TicketDTO;
//import com.github.solairerove.woodstock.dto.UnitDTO;
//
//public class ModelMapper {
//
//    public static Unit convertToUnit(UnitDTO unitDTO) {
//        Unit unit = new Unit();
//        unit.setLabel(unitDTO.getLabel());
//        unit.setDescription(unitDTO.getDescription());
//
//        return unit;
//    }
//
//    public static Module convertToModule(ModuleDTO moduleDTO) {
//        Module module = new Module();
//        module.setName(moduleDTO.getName());
//        module.setAvatar(moduleDTO.getAvatar());
//        module.setDescription(moduleDTO.getDescription());
//
//        return module;
//    }
//
//    public static Reference convertToReference(ReferenceDTO referenceDTO) {
//        Reference reference = new Reference();
//        reference.setTitle(referenceDTO.getTitle());
//        reference.setVersion(referenceDTO.getVersion());
//
//        return reference;
//    }
//
//    public static Chapter convertToChapter(ChapterDTO chapterDTO) {
//        Chapter chapter = new Chapter();
//        chapter.setTitle(chapterDTO.getTitle());
//        chapter.setContent(chapterDTO.getContent());
//
//        return chapter;
//    }
//
//    public static Task convertToTask(TaskDTO taskDTO) {
//        Task task = new Task();
//        task.setQuestion(taskDTO.getQuestion());
//
//        return task;
//    }
//
//    public static Ticket convertToTicket(TicketDTO ticketDTO) {
//        Ticket ticket = new Ticket();
//        ticket.setValue(ticketDTO.getValue());
//
//        return ticket;
//    }
//}
