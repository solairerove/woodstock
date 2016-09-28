package com.github.solairerove.woodstock.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

/**
 * Created by krivitski-no on 9/28/16.
 */
@Data
@Document
public class Ticket implements Serializable{

    @Id
    private String id;

    private String value;
}
