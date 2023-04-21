package cherry.domain;

import cherry.dto.grade.GradeForm;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@Table(name="grade")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Grade {

    @Id @GeneratedValue
    @Column(name="grade_id")
    private Long id;
    private Long score;

    @ManyToOne
    private Student student;

    @ManyToOne
    private Subject subject;

    public static Grade of(Student student,Subject subject,Long score){

        Grade grade = new Grade();
        grade.student=student;
        grade.subject=subject;
        grade.score=score;
        return grade;
    }

}
