package cherry.dto.student;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentForm {

    @NotNull(message = "이름은 필수값입니다")
    private String studentName;
}
