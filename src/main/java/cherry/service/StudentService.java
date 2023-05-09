package cherry.service;

import cherry.domain.Student;
import cherry.dto.student.StudentForm;
import cherry.dto.student.StudentResponse;
import cherry.dto.student.StudentScoreResponse;
import cherry.exception.DomainException;
import cherry.mapper.StudentMapper;
import cherry.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;
    @Transactional
    public StudentResponse createStudent(StudentForm request) {

        if(request.getStudentName() == null){
            throw new NullPointerException(request.getStudentName());
        }
        //학생 객체 생성해서 request에서 받은 내용 변환해주기
        Student student = studentMapper.toStudent(request);

        //학생 객체를 리포지토리에 저장(리포지토리는 학생객체로 받기 때문)
        studentRepository.save(student);

        //리포지토리에 저장한 학생객체를 response객체로 담아서 반환
        //return new StudentResponse(student);
        return studentMapper.toStudentResponse(student);
    }

    public void deleteStudent(Long id){
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> DomainException.notFoundRow(id));
        student.delete();
    }

    @Transactional
    public StudentResponse getStudent(Long id){
        Student student = studentRepository.findById(id)
                .orElseThrow(()->DomainException.notFoundRow(id));
        return new StudentResponse(student);
    }

    @Transactional
    public List<StudentResponse> getStudentList(){
        List<StudentResponse> list = new ArrayList<>();
        for (Student student : studentRepository.findAll()){
            StudentResponse response = new StudentResponse(student);
            list.add(response);
        }
        return list;
    }

    @Transactional(readOnly = true)
    public StudentScoreResponse getStudentAvgScore(Long id) {
        Student student = studentRepository.findById(id).orElseThrow(()->DomainException.notFoundRow(id));
        double score = student.getStudentAvgScore();
        return new StudentScoreResponse(student.getStudentName(),score);
    }
}
