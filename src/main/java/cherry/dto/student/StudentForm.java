package cherry.dto.student;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StudentForm {

    @NotNull(message = "이름은 필수값입니다")
    private String studentName;
    private StudentAddressForm address;

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class StudentAddressForm{
        private String city;
        private String street;
        private String zipcode;
    }
}
