package cherry.dto.grade;

import cherry.domain.SubjectType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GradeForm {
    @NotNull(message = "이름은 필수값입니다")
    private String studentName;
    @NotNull(message = "과목은 필수값입니다")
    private String subjectName;
    @NotNull(message = "점수는 필수값입니다")
    private Long score;

    public SubjectType getSubjectType(){
        return SubjectType.valueOf(subjectName);
    }
}
