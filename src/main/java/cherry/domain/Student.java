package cherry.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@NoArgsConstructor
@Entity
@Table(name="student")
public class Student {

    @Id @GeneratedValue
    private Long id;

    private String studentName;

    @Builder
    public Student(String name){
        this.studentName = name;
    }
}
