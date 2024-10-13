package pro.sky.java.course2.examineservice.controller;
import org.springframework.web.bind.annotation.*;
import pro.sky.java.course2.examineservice.service.ExaminerService;
import pro.sky.java.course2.examineservice.domain.Question;
import java.util.Collection;


@RestController
@RequestMapping("/yourQuestions")
public class ExamController {

    private final ExaminerService service;

    public ExamController(ExaminerService examinerService) {
        this.service = examinerService;
    }
    @GetMapping
    public Collection<Question> getQuestion(@RequestParam("Number of questions")
                                            int amount){
        return this.service.getQuestion(amount);
    }

}
