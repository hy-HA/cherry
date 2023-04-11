package cherry.service;

import cherry.domain.Student;
import cherry.dto.StudentForm;
import cherry.dto.StudentResponse;
import cherry.exception.DomainException;
import cherry.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;

    @Transactional
    public StudentResponse createStudent(StudentForm request) {

        if(request.getStudentName() == null){
            throw new NullPointerException(request.getStudentName());
        }
        //학생 객체 생성해서 request에서 받은 내용 변환해주기
        Student student = Student.builder()
                .name(request.getStudentName())
                .build();
        //학생 객체를 리포지토리에 저장(리포지토리는 학생객체로 받기 때문)
        studentRepository.save(student);

        //리포지토리에 저장한 학생객체를 response객체로 담아서 반환
        return new StudentResponse(student);
    }

    public void deleteStudent(Long id){
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> DomainException.notFoundRow(id));
        student.delete();
    }
}
