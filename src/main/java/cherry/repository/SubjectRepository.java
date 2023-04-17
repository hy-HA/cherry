package cherry.repository;

import cherry.domain.Subject;
import cherry.domain.SubjectType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SubjectRepository extends JpaRepository<Subject, Long> {
    Optional<Subject> findBySubjectType(SubjectType subjectType);
}
