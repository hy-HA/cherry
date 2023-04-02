package cherry.service;

import cherry.dto.StudentForm;
import cherry.dto.StudentResponse;
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

        StudentResponse response = new StudentResponse(request);
        studentRepository.save(response);
        return response;
    }
}
