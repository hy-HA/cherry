package cherry.dto.student;

import cherry.domain.Student;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class StudentScoreResponse {

    private String studentName;
    private double score;
    public StudentScoreResponse(String studentName, double score){
        this.studentName=studentName;
        this.score=score;
    }
}
