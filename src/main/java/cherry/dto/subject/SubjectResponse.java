package cherry.dto.subject;

import cherry.domain.Student;
import cherry.domain.Subject;
import cherry.domain.SubjectType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubjectResponse {

    private Long id;
    private String subjectType;

    public SubjectResponse(Subject subject){
        this.id = subject.getId();
        this.subjectType = subject.getSubjectType();
    }
}
