package pro.sky.java.course2.examineservice.service;

import org.springframework.stereotype.Service;
import pro.sky.java.course2.examineservice.domain.Question;
import pro.sky.java.course2.examineservice.exeptions.WrongQuestionAmountException;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;



@Service
public class ExaminerServiceImpl implements ExaminerService {

    private final QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public Collection<Question> getQuestion(int amount) {

        if (amount < 1 || amount > questionService.getAll().size()) {
            throw new WrongQuestionAmountException();
        }

        Set<Question> checklist = new HashSet<>();

        while (checklist.size() < amount) {
            checklist.add(questionService.getRandomQuestion());
        }
        return checklist;
    }

}
