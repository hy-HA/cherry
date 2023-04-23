package cherry.service;

import cherry.domain.Grade;
import cherry.domain.Student;
import cherry.domain.Subject;
import cherry.dto.grade.GradeForm;
import cherry.dto.grade.GradeResponse;
import cherry.dto.grade.GradeUpdateForm;
import cherry.exception.DomainException;
import cherry.exception.NullException;
import cherry.repository.GradeRepository;
import cherry.repository.StudentRepository;
import cherry.repository.SubjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.NotNull;

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
                .orElseThrow(()-> DomainException.notFoundRow(request.getSubjectName()));

        Grade grade = Grade.of(student,subject, request.getScore());

        gradeRepository.save(grade);
        return new GradeResponse(grade);

    }

    @Transactional
    public void updateGrade(Long id, GradeUpdateForm request) {

        Grade grade = gradeRepository.findById(id)
                .orElseThrow(()->DomainException.notFoundRow(id));

        grade.updateScore(request.getScore());
    }

    @Transactional
    public void deleteGrade(Long id) {

        Grade grade = gradeRepository.findById(id).orElseThrow(()-> DomainException.notFoundRow(id));
        grade.delete();
    }
}
