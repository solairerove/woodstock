package com.github.solairerove.woodstock.job;

import com.github.solairerove.woodstock.domain.Unit;
import com.github.solairerove.woodstock.repository.UnitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MyBean implements CommandLineRunner {

    private final UnitRepository repository;

    @Autowired
    public MyBean(UnitRepository repository) {
        this.repository = repository;
    }

    public void run(String... args) {
        Unit unit = new Unit();
        unit.setLabel("");
        unit.setAvatar("");
        unit.setDescription("");

        System.out.println(repository.save(unit));
    }
}