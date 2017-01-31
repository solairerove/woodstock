//package com.github.solairerove.woodstock.domain;
//
//import lombok.Data;
//import org.neo4j.ogm.annotation.GraphId;
//import org.neo4j.ogm.annotation.NodeEntity;
//import org.neo4j.ogm.annotation.Relationship;
//
//import java.io.Serializable;
//import java.util.ArrayList;
//import java.util.List;
//
//@Data
//@NodeEntity(label = "Task")
//public class Task implements Serializable {
//
//    @GraphId
//    private Long id;
//
//    private String question;
//
//    @Relationship(type = "HAS_IN", direction = Relationship.INCOMING)
//    private List<Ticket> tickets;
//
//    public List<Ticket> getTickets() {
//        if (tickets == null) {
//            tickets = new ArrayList<>();
//        }
//
//        return tickets;
//    }
//}
