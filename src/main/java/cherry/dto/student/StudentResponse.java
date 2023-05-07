package cherry.dto.student;

import cherry.domain.Student;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StudentResponse {

    private Long id;
    private String studentName;
    private String city;
    private String street;
    private String zipcode;

    public StudentResponse(Student request) {
        this.id = request.getId();
        this.studentName = request.getStudentName();

    }
    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class StudentAddressResponse {
        private String address1;
        private String address2;
        private String address3;
    }

}
