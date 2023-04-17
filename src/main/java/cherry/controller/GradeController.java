package cherry.controller;

import cherry.domain.Grade;
import cherry.dto.grade.GradeForm;
import cherry.dto.grade.GradeResponse;
import cherry.service.GradeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/grade")
public class GradeController {

    private final GradeService gradeService;

    @PostMapping
    @ResponseBody
    public ResponseEntity<GradeResponse> createGrade(@RequestBody GradeForm request){
        GradeResponse response = gradeService.createGrade(request);
        return ResponseEntity.ok(response);
    }

}
