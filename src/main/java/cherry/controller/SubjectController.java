package cherry.controller;

import cherry.dto.subject.SubjectForm;
import cherry.dto.subject.SubjectResponse;
import cherry.service.SubjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class SubjectController {
    private final SubjectService subjectService;

    @ResponseBody
    @PostMapping("/subject")
    public ResponseEntity<SubjectResponse> createSubject(@RequestBody SubjectForm request){
        SubjectResponse subjectResponse = subjectService.createSubject(request);
        return ResponseEntity.ok(subjectResponse);
    }

    @ResponseBody
    @DeleteMapping("/subject/{id}")
    public ResponseEntity<SubjectResponse> deleteSubject(@PathVariable Long id){
        subjectService.deleteSubject(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
