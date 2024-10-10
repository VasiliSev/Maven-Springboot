package pro.sky.java.course2.service;

import org.junit.jupiter.api.Test;
import pro.sky.java.course2.examenservice.service.JavaQuestionService;
import pro.sky.java.course2.examenservice.service.QuestionService;
import pro.sky.java.course2.examinservice.domain.Question;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

public class JavaQuestionServiceTest {

    private final QuestionService questionService = new JavaQuestionService();

    @Test
    void addTest() {

        //данный тест проверяет оба метода add, поскольку мы вручную создаем
        // объект Question и передаем его в метод add

        int questionNumber = questionService.getAll().size();

        questionService.add(new Question("question1", "answer1"));
        questionService.add(new Question("question2", "answer2"));

        int currentQuestionNumber = questionService.getAll().size();
        int expectedQuestionNumber = questionNumber + 2;

        assertEquals(expectedQuestionNumber, currentQuestionNumber);
    }

    @Test
    void removeTest() {

        questionService.add(new Question("question1", "answer1"));
        questionService.add(new Question("question2", "answer2"));
        questionService.add(new Question("question3", "answer3"));
        questionService.add(new Question("question4", "answer4"));

        int questionNumber = questionService.getAll().size();

        Set<Question> questionsToRemove = questionService.getAll()
                .stream()
                .limit(questionNumber - 1)
                .collect(Collectors.toSet());

        questionsToRemove.forEach(questionService::remove);
        Collection<Question> restQuestion = questionService.getAll();

        assertEquals(1, restQuestion.size());

        boolean isRemovingSucces = restQuestion.stream()
                .noneMatch(questionsToRemove::contains);

        assertTrue(isRemovingSucces);
    }

    @Test
    void getRandomQuestionTest() {

        Set<Question> questionsToRemove = new HashSet<>(questionService.getAll());
        questionsToRemove.forEach(questionService::remove);

        assertThrows(IllegalStateException.class, questionService::getRandomQuestion);

    }

}
