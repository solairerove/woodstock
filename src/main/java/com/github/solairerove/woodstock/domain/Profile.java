package com.github.solairerove.woodstock.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@Document(collection = "profiles")
public class Profile implements Serializable {

    @Id
    private String id;

    private String username;

    private String login;

    private String password;

    private String hashPassword;

    private List<String> units;

    public Profile() {
        this.units = new ArrayList<>();
    }

    public void add(String unit) {
        this.units.add(unit);
    }
}
