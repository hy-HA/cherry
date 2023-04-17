package cherry.dto.grade;

import cherry.domain.Grade;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GradeResponse {


    private String studentName;

    private String subjectType;

    private Long score;

    public GradeResponse(Grade grade){
        this.studentName = grade.getStudent().getStudentName();
        this.subjectType = grade.getSubject().getSubjectType();
        this.score=grade.getScore();
    }
}
