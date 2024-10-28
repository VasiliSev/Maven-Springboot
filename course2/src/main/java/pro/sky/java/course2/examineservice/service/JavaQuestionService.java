package pro.sky.java.course2.examineservice.service;
import org.springframework.stereotype.Service;
import pro.sky.java.course2.examineservice.domain.Question;
import java.util.*;
import static java.util.Collections.unmodifiableCollection;

@Service
public class JavaQuestionService implements QuestionService {

    private static final Random RANDOM = new Random();

    private final Set<Question> questions = new HashSet<>();

    @Override
    public Question add(String question, String answer) {
        Question questionAdded = new Question(question, answer);
        questions.add(questionAdded);
        return questionAdded;
    }

    @Override
    public Question add(Question question) {
        questions.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        questions.remove(question);
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        return unmodifiableCollection(questions);
    }

    @Override
    public Question getRandomQuestion() {
        if(questions.isEmpty()){
            throw new IllegalStateException("Хранилище для вопросов пустое");
        }

        int questionIndex = RANDOM.nextInt(questions.size());
        return new ArrayList<>(questions).get(questionIndex);
    }

}
