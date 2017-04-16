package com.github.solairerove.woodstock.job;

import com.github.solairerove.woodstock.domain.Answer;
import com.github.solairerove.woodstock.domain.Chapter;
import com.github.solairerove.woodstock.domain.Module;
import com.github.solairerove.woodstock.domain.Question;
import com.github.solairerove.woodstock.domain.Reference;
import com.github.solairerove.woodstock.domain.Unit;
import com.github.solairerove.woodstock.repository.UnitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Profile("generate")
public class GenerateJob implements CommandLineRunner {

    private final UnitRepository repository;

    @Autowired
    public GenerateJob(UnitRepository repository) {
        this.repository = repository;
    }

    public void run(String... args) {
//
//        int count = 0;
//        List<Unit> units = new ArrayList<>();
//        for (int u = 0; u < 3; u++) {
//            Unit unit = new Unit();
//            unit.setLabel("Unit label " + u);
//            unit.setAvatar("Unit avatar link");
//            unit.setDescription("Unit MD short description");
//            count++;
//
//            for (int m = 0; m < 5; m++) {
//                Module module = new Module();
//                module.setName("Module name " + u + "->" + m);
//                module.setAvatar("Module lint to avatar image");
//                module.setDescription("MD short description");
//                count++;
//
//                for(int q = 0; q < 35; q++) {
//                    Question question = new Question();
//                    question.setQuestion("Question " + "Reference title " + u + "->" + m + "->" + q);
//                    count++;
//
//                    for(int a = 0; a < 10; a++) {
//                        Answer answer = new Answer();
//                        answer.setAnswer("Answer" + u + "->" + m + "->" + q + "->" + a);
//                        answer.setEnable(true);
//                        answer.setCorrect(a % 5 == 0);
//                        count++;
//
//                        question.add(answer);
//                    }
//                    module.addQuestion(question);
//                }
//
//                for (int r = 0; r < 8; r++) {
//                    Reference reference = new Reference();
//                    reference.setTitle("Reference title " + u + "->" + m + "->" + r);
//                    reference.setVersion("v1");
//                    count++;
//
//                    for (int c = 0; c < 10; c++) {
//                        Chapter chapter = new Chapter();
//                        chapter.setTitle("Chapter title " + u + "->" + m + "->" + r + "->" + c);
//                        chapter.setContent("MD chapter content");
//                        count++;
//
//                        reference.add(chapter);
//                    }
//                    module.addReference(reference);
//                }
//                unit.add(module);
//            }
//            units.add(unit);
//        }
//
//        units.forEach(u -> {
//            System.out.println(u.getLabel());
//            u.getModules().forEach(m -> {
//                System.out.println(m.getName());
//                m.getQuestions().forEach(q -> {
//                    System.out.println(q.getQuestion());
//                    q.getAnswers().forEach(System.out::println);
//                });
//                m.getReferences().forEach(r -> {
//                    System.out.println(r.getTitle());
//                    r.getChapters().forEach(System.out::println);
//                });
//            });
//        });
//        System.out.println("Actually: " + count);
//
//        repository.deleteAll();
//        repository.save(units);
    }
}