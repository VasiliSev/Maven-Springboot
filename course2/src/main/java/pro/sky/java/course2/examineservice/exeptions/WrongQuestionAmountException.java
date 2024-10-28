package pro.sky.java.course2.examineservice.exeptions;
import org.springframework.web.bind.annotation.ResponseStatus;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@ResponseStatus(value = BAD_REQUEST)
public class WrongQuestionAmountException extends RuntimeException{
}
