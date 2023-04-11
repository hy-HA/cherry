package cherry.domain;

import cherry.domain.base.BaseEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Where;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@NoArgsConstructor
@Entity
@Table(name="student")
@Where(clause="is_deleted = false")
public class Student extends BaseEntity {

    @Id @GeneratedValue
    private Long id;

    private String studentName;

    @Builder
    public Student(String name){
        this.studentName = name;
    }
}
