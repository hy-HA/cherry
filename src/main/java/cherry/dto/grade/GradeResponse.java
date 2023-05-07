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

    private Long id;
    private String studentName;

    private String subjectType;

    private Integer score;

    public GradeResponse(Grade grade){
        this.id=grade.getId();
        this.studentName = grade.getStudentName();
        this.subjectType = grade.getSubjectType();
        this.score=grade.getScore();
    }
}
