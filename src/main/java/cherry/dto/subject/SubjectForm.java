package cherry.dto.subject;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "과목정보")
public class SubjectForm {

    @NotNull(message = "이름은 필수값입니다")
    private String subjectType;
}
