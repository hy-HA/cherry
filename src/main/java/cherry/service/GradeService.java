package cherry.service;

import cherry.domain.Grade;
import cherry.domain.Student;
import cherry.domain.Subject;
import cherry.dto.grade.GradeForm;
import cherry.dto.grade.GradeResponse;
import cherry.exception.DomainException;
import cherry.exception.NullException;
import cherry.repository.GradeRepository;
import cherry.repository.StudentRepository;
import cherry.repository.SubjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class GradeService {

    private final GradeRepository gradeRepository;
    private final StudentRepository studentRepository;
    private final SubjectRepository subjectRepository;

    @Transactional
    public GradeResponse createGrade(GradeForm request){


        Student student = studentRepository.findByStudentName(request.getStudentName())
                .orElseThrow(()-> DomainException.notFoundRow(request.getStudentName()));
        Subject subject = subjectRepository.findBySubjectType(request.getSubjectType())
                .orElseThrow(()-> DomainException.notFoundRow(request.getStringSubjectType()));
        Grade grade = Grade.of(student,subject, request.getScore());
        gradeRepository.save(grade);
        return new GradeResponse(grade);

    }
}
