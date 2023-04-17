package cherry.domain;

import cherry.dto.grade.GradeForm;
import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Getter
@Entity
public class Grade {

    @Id @GeneratedValue
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
