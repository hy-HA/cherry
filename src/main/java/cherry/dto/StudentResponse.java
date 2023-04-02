package cherry.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentResponse {

    private Long id;
    private String studentName;

    public StudentResponse(StudentForm request) {
        this.id = request.getId();
        this.studentName = request.getStudentName();
    }
}
