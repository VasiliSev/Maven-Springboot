package pro.sky.java.course2.service;


import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.mockito.junit.jupiter.MockitoExtension;

import pro.sky.java.course2.examenservice.service.ExaminerServiceImpl;

import pro.sky.java.course2.examenservice.service.QuestionService;
import pro.sky.java.course2.examinservice.domain.Question;
import pro.sky.java.course2.exeptions.WrongQuestionAmountException;


import java.util.Collection;
import java.util.Objects;
import java.util.Random;
import java.util.stream.IntStream;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ExaminerServiceTest {

    private static final Random RANDOM = new Random();

    @Mock
    private QuestionService questionService;

    @InjectMocks
    private ExaminerServiceImpl examinerService;

    @ParameterizedTest
    @ValueSource(ints = {5, 10})
    void getQuestionTest(int amount) {

        Collection<Question> questions = IntStream.generate(RANDOM::nextInt)
                .limit(amount)
                .boxed()
                .map(Objects::toString)
                .map(s -> new Question(s, s))
                .toList();

        when(questionService.getAll())
                .thenReturn(questions);

        when(questionService.getRandomQuestion())
                .thenAnswer(invocation ->
                        new Question(
                                RANDOM.nextLong() + "",
                                RANDOM.nextLong() + ""
                        ));
        Collection<Question> actualQuestions = examinerService.getQuestion(amount);

        assertEquals(amount, actualQuestions.size());
        verify(questionService, atLeast(amount)).getRandomQuestion();
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -2})
    void getQuestionNegativeTest(int amount) {
        assertThrows(WrongQuestionAmountException.class, () ->
                examinerService.getQuestion(amount));
    }

    @ParameterizedTest
    @ValueSource(ints = {5, 10})
    void getQuestionExceedingTest(int amount) {

        Collection<Question> questions = IntStream.generate(RANDOM::nextInt)
                .limit(amount - 1)
                .boxed()
                .map(Objects::toString)
                .map(s -> new Question(s, s))
                .toList();

        when(questionService.getAll())
                .thenReturn(questions);

        assertThrows(WrongQuestionAmountException.class, () ->
                examinerService.getQuestion(amount));
    }
}