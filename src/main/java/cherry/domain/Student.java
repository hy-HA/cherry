package cherry.domain;

import cherry.domain.base.BaseEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
@Table(name="student")
@Where(clause="is_deleted = false")
public class Student extends BaseEntity {

    @Id @GeneratedValue
    private Long id;
    private String studentName;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private List<Grade> grades = new ArrayList<>();
    @Builder
    public Student(String name){
        this.studentName = name;
    }

    public double getStudentAvgScore(){
        return grades.stream()
                .mapToLong(Grade::getScore)
                .average()
                .orElseThrow();
    }
}
