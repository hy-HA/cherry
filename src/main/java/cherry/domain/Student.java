package cherry.domain;

import cherry.domain.base.BaseEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.apache.tomcat.jni.Address;
import org.hibernate.annotations.Where;
import org.springframework.core.annotation.MergedAnnotation;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;

@Getter
@NoArgsConstructor
@Entity
@Table(name="student")
@Where(clause="is_deleted = false")
public class Student extends BaseEntity {

    @Id @GeneratedValue
    private Long id;
    private String studentName;

    @Embedded
    private Address address;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private List<Grade> grades = new ArrayList<>();
    @Builder
    public Student(String name, Address address){
        this.studentName = name;
        this.address=address;
        this.isDeleted = false;
    }


    public double getStudentAvgScore(){

        ToIntFunction<Grade> gradeToIntFunction = x -> x.getScore();

        return grades.stream()
//                .mapToDouble(Grade::getScore)
                .mapToInt(gradeToIntFunction)
                .average()
                .orElseThrow();
    }
}
