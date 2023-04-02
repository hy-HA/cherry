package cherry.controller;

import cherry.dto.StudentForm;
import cherry.dto.StudentResponse;
import cherry.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/student")
public class StudentController {

    private final StudentService studentService;

    @ResponseBody
    @PostMapping
    public ResponseEntity<StudentResponse> createStudent(@RequestBody StudentForm request) {
        StudentResponse response = studentService.createStudent(request);
        return ResponseEntity.ok(response);
    }


}