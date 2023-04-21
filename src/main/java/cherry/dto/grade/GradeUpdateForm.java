package cherry.dto.grade;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GradeUpdateForm {

    @NotNull(message = "점수는 필수값입니다")
    private Long score;
}
