package cherry.service;

import cherry.domain.Subject;
import cherry.dto.subject.SubjectAvgScore;
import cherry.dto.subject.SubjectForm;
import cherry.dto.subject.SubjectResponse;
import cherry.exception.DomainException;
import cherry.exception.NullException;
import cherry.repository.SubjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SubjectService {
    private final SubjectRepository subjectRepository;

    @Transactional
    public SubjectResponse createSubject(SubjectForm request){

        //TODO null예외처리 하기
        if(request.getSubjectType() == null) {
            throw new NullException(request.getSubjectType());
        }

        //subject 객체 생성
        Subject subject = Subject.builder()
                .subjectType(request.getSubjectType())
                .build();
        //subject 객체 리포지토리에 저장
        subjectRepository.save(subject);
        //subject 객체 반환
        return new SubjectResponse(subject);
    }

    @Transactional
    public void deleteSubject(Long id){
        Subject subject = subjectRepository.findById(id)
                .orElseThrow(() -> DomainException.notFoundRow(id));
        subject.delete();
    }

    @Transactional
    public SubjectResponse getSubject(Long id){
        Subject subject = subjectRepository.findById(id)
                .orElseThrow(()->DomainException.notFoundRow(id));
        return new SubjectResponse(subject);
    }

    @Transactional
    public List<SubjectResponse> getSubjectList(){
        List<SubjectResponse> list = new ArrayList<>();
        for(Subject subject : subjectRepository.findAll()){
            SubjectResponse response = new SubjectResponse(subject);
            list.add(response);
        }
        return list;
    }

    @Transactional
    public SubjectAvgScore getSubjectAvgScore(Long id){
        Subject subject = subjectRepository.findById(id).orElseThrow(()->DomainException.notFoundRow(id));
        return SubjectAvgScore.builder()
                .subjectName(subject.getSubjectType())
                .score(subject.getSubjectAvgScore())
                .build();

    }

}
