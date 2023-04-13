package cherry.service;

import cherry.domain.Subject;
import cherry.dto.subject.SubjectForm;
import cherry.dto.subject.SubjectResponse;
import cherry.exception.DomainException;
import cherry.repository.SubjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class SubjectService {
    private final SubjectRepository subjectRepository;

    @Transactional
    public SubjectResponse createSubject(SubjectForm request){

        //TODO null예외처리 하기

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
}
