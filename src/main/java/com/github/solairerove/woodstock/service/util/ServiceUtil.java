package com.github.solairerove.woodstock.service.util;

import com.github.solairerove.woodstock.domain.Chapter;
import com.github.solairerove.woodstock.domain.Module;
import com.github.solairerove.woodstock.domain.Reference;
import com.github.solairerove.woodstock.repository.UnitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ServiceUtil {

    private final UnitRepository repository;

    @Autowired
    public ServiceUtil(UnitRepository repository) {
        this.repository = repository;
    }

    public Module getModule(String unitId, String moduleId) {
        return this.repository
                .findOne(unitId)
                .getModules()
                .stream()
                .filter(el -> moduleId.equals(el.getId()))
                .findFirst()
                .orElse(null);
    }

    public Reference getReference(String unitId, String moduleId, String refId) {
        return this.getModule(unitId, moduleId)
                .getReferences()
                .stream()
                .filter(el -> el.getId().equals(refId))
                .findFirst()
                .orElse(null);
    }

    public Chapter getChapter(String unitId, String moduleId, String refId, String chapterId) {
        return this.getReference(unitId, moduleId, refId)
                .getChapters()
                .stream()
                .filter(el -> chapterId.equals(el.getId()))
                .findFirst()
                .orElse(null);
    }

    public List<Module> getModules(String unitId) {
        return repository
                .findOne(unitId)
                .getModules();
    }

    public List<Reference> getReferences(String unitId, String moduleId) {
        return this.getModule(unitId, moduleId)
                .getReferences();
    }

    public List<Chapter> getChapters(String unitId, String moduleId, String refId) {
        return this.getReference(unitId, moduleId, refId)
                .getChapters();
    }
}
