package com.github.solairerove.woodstock.service.impl.chapter;

import com.github.solairerove.woodstock.repository.chapter.ModuleChapterRepository;
import com.github.solairerove.woodstock.service.chapter.ModuleChapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ModuleChapterServiceImpl implements ModuleChapterService {

    private final ModuleChapterRepository repository;

    @Autowired
    public ModuleChapterServiceImpl(ModuleChapterRepository repository) {
        this.repository = repository;
    }
}
