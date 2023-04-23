package cherry.controller;

import cherry.dto.subject.SubjectAvgScore;
import cherry.dto.subject.SubjectForm;
import cherry.dto.subject.SubjectResponse;
import cherry.service.SubjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/subject")
public class SubjectController {
    private final SubjectService subjectService;

    @ResponseBody
    @PostMapping
    public ResponseEntity<SubjectResponse> createSubject(@RequestBody SubjectForm request){
        SubjectResponse subjectResponse = subjectService.createSubject(request);
        return ResponseEntity.ok(subjectResponse);
    }

    @ResponseBody
    @DeleteMapping("/{id}")
    public ResponseEntity<SubjectResponse> deleteSubject(@PathVariable Long id){
        subjectService.deleteSubject(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @ResponseBody
    @GetMapping("/{id}")
    public ResponseEntity<SubjectResponse> getSubject(@PathVariable Long id){
        SubjectResponse response = subjectService.getSubject(id);
        return ResponseEntity.ok(response);
    }

    @ResponseBody
    @GetMapping
    public ResponseEntity<List<SubjectResponse>> getSubjectList(){
        List<SubjectResponse> list = subjectService.getSubjectList();
        return ResponseEntity.ok(list);
    }

    @ResponseBody
    @GetMapping("/{id}/score")
    public ResponseEntity<SubjectAvgScore> getSubjectAvgScore(@PathVariable Long id){
        SubjectAvgScore response = subjectService.getSubjectAvgScore(id);
        return ResponseEntity.ok(response);
    }
}
