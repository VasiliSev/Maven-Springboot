package pro.sky.java.course2.examineservice.controller;
import org.springframework.web.bind.annotation.*;
import pro.sky.java.course2.examineservice.service.QuestionService;
import pro.sky.java.course2.examineservice.domain.Question;
import java.util.Collection;

@RestController
@RequestMapping("/exam/java")
public class JavaQuestionController {

    private final QuestionService service;

    public JavaQuestionController(QuestionService questionService) {
        this.service = questionService;
    }

    @GetMapping("/add")
    public Question addQuestion(@RequestParam("Question Text") String question,
                        @RequestParam("Answer Text") String answer) {
        return this.service.add(question, answer);
    }

    @GetMapping
    public Collection<Question> getAll(){
        return this.service.getAll();
    }

    @GetMapping("/remove")
    public Question removeQuestion(@RequestParam("Question Text") String question,
                        @RequestParam("Answer Text") String answer) {
        return this.service.remove(new Question(question, answer));
    }
}
