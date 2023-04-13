package cherry.domain;

import cherry.domain.base.BaseEntity;
import cherry.exception.TypeException;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.Where;

import javax.persistence.*;

@Getter
@Entity
@Table(name = "subject")
@RequiredArgsConstructor
@Where(clause = "is_deleted = false")
public class Subject extends BaseEntity {

    @Id @GeneratedValue
    private Long id;

    @Enumerated(value = EnumType.ORDINAL)
    @Column(name = "subject_type",unique = true)
    private SubjectType subjectType;

    //Subject 생성 : SubjectForm에서 받은 String 필드로 Subject객체 생성하기
    @Builder
    public Subject(String subjectType){
        initSubject(subjectType);
        this.isDeleted = false;
    }

    private void initSubject(String subjectType) {
        try {
            this.subjectType = SubjectType.valueOf(subjectType);
        } catch (IllegalArgumentException e){
            throw TypeException.of("과목", subjectType);
        }
    }

    //SubjectType String으로 반환하는 getter 메소드
    public String getSubjectType(){
        return subjectType.name();
    }

}
