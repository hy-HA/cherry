package cherry.controller;

import cherry.dto.student.StudentForm;
import cherry.dto.student.StudentResponse;
import cherry.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @ResponseBody
    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Long id){
        studentService.deleteStudent(id);
    }

    @ResponseBody
    @GetMapping("/{id}")
    public ResponseEntity<StudentResponse> getStudent(@PathVariable Long id){
        StudentResponse response = studentService.getStudent(id);
        return ResponseEntity.ok(response);
    }

    @ResponseBody
    @GetMapping
    public ResponseEntity<List<StudentResponse>> getStudentList(){
        List<StudentResponse> response = studentService.getStudentList();
        return ResponseEntity.ok(response);
    }



}
