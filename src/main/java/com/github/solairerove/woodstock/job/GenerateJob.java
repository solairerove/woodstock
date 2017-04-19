package com.github.solairerove.woodstock.job;

import com.github.solairerove.woodstock.domain.Answer;
import com.github.solairerove.woodstock.domain.Chapter;
import com.github.solairerove.woodstock.domain.Module;
import com.github.solairerove.woodstock.domain.Question;
import com.github.solairerove.woodstock.domain.Reference;
import com.github.solairerove.woodstock.domain.Unit;
import com.github.solairerove.woodstock.repository.AnswerRepository;
import com.github.solairerove.woodstock.repository.ChapterRepository;
import com.github.solairerove.woodstock.repository.ModuleRepository;
import com.github.solairerove.woodstock.repository.QuestionRepository;
import com.github.solairerove.woodstock.repository.ReferenceRepository;
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

    private final UnitRepository unitRepository;

    private final ModuleRepository moduleRepository;

    private final ReferenceRepository referenceRepository;

    private final ChapterRepository chapterRepository;

    private final QuestionRepository questionRepository;

    private final AnswerRepository answerRepository;

    @Autowired
    public GenerateJob(final UnitRepository unitRepository,
                       final ModuleRepository moduleRepository,
                       final ReferenceRepository referenceRepository,
                       final ChapterRepository chapterRepository,
                       final QuestionRepository questionRepository,
                       final AnswerRepository answerRepository) {
        this.unitRepository = unitRepository;
        this.moduleRepository = moduleRepository;
        this.referenceRepository = referenceRepository;
        this.chapterRepository = chapterRepository;
        this.questionRepository = questionRepository;
        this.answerRepository = answerRepository;
    }

    public void run(String... args) {

        int count = 0;
        List<Unit> units = new ArrayList<>();
        for (int u = 0; u < 3; u++) {
            Unit unit = new Unit(
                    "Unit label " + u,
                    "Unit avatar link",
                    "MD short description"
            );
            count++;

            for (int m = 0; m < 5; m++) {
                Module module = new Module(
                        "Module name " + u + "->" + m,
                        "Module link to avatar image",
                        "MD short description"
                );
                count++;

                for(int q = 0; q < 35; q++) {
                    Question question = new Question("Question " + u + "->" + m + "->" + q);
                    count++;

                    for(int a = 0; a < 10; a++) {
                        Answer answer = new Answer(
                                "Answer" + u + "->" + m + "->" + q + "->" + a,
                                true,
                                a % 5 == 0
                        );
                        count++;

                        answerRepository.save(answer);
                        question.add(answer.getId());
                    }
                    questionRepository.save(question);
                    module.addQuestion(question.getId());
                }

                for (int r = 0; r < 8; r++) {
                    Reference reference = new Reference(
                            "Reference title " + u + "->" + m + "->" + r,
                            "v1"
                    );
                    count++;

                    for (int c = 0; c < 10; c++) {
                        Chapter chapter = new Chapter(
                                "Chapter title " + u + "->" + m + "->" + r + "->" + c,
                                "MD chapter content"
                        );
                        count++;
                        chapterRepository.save(chapter);
                        reference.add(chapter.getId());
                    }
                    referenceRepository.save(reference);
                    module.addReference(reference.getId());
                }
                moduleRepository.save(module);
                unit.add(module.getId());
            }
            units.add(unit);
        }

        System.out.println("Actually: " + count);

        unitRepository.deleteAll();
        moduleRepository.deleteAll();
        referenceRepository.deleteAll();
        chapterRepository.deleteAll();
        questionRepository.deleteAll();
        answerRepository.deleteAll();

        unitRepository.save(units);
    }
}