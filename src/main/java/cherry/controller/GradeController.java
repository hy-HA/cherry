package cherry.controller;

import cherry.domain.Grade;
import cherry.dto.grade.GradeForm;
import cherry.dto.grade.GradeResponse;
import cherry.dto.grade.GradeUpdateForm;
import cherry.service.GradeService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
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

    @PatchMapping ("/{id}/score")
    @ResponseBody
    public ResponseEntity<Void> updateGrade(
                                                @PathVariable Long id,
                                                @RequestBody GradeUpdateForm request){
       gradeService.updateGrade(id,request);
       return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping("/{id}")
    public void deleteGrade(@PathVariable Long id){
        gradeService.deleteGrade(id);
    }

}
