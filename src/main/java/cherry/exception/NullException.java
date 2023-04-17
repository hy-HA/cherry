package cherry.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.constraints.NotNull;
@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR, reason = "null값은 허용하지 않음")
public class NullException extends RuntimeException {
    public NullException(String message) {
        super(message);
    }
    public static NullException notNull(){
        return new NullException("공백일 수 없습니다");
    }
}
