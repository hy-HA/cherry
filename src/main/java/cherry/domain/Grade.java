package cherry.domain;

import cherry.domain.base.BaseEntity;
import cherry.dto.grade.GradeForm;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Where;

import javax.persistence.*;

@Getter
@Entity
@Table(name="grade")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Where(clause = "is_deleted = false")
public class Grade extends BaseEntity {

    @Id @GeneratedValue
    @Column(name="grade_id")
    private Long id;
    private Long score;
    @ManyToOne
    private Student student;
    @ManyToOne
    private Subject subject;

    //static 사용해야 서비스에서 of메소드를 사용할 수 있음🧩 
    public static Grade of(Student student,Subject subject,Long score){

        Grade grade = new Grade();
        grade.student=student;
        grade.subject=subject;
        grade.score=score;
        return grade;
    }


    public String getSubjectType(){
        return this.subject.getSubjectType();
    }
    public String getStudentName(){
        return this.student.getStudentName();
    }
    public void updateScore(Long score){
        this.score = score;
    }

}
