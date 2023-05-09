package cherry.mapper;

import cherry.domain.Student;
import cherry.domain.value.Address;
import cherry.dto.student.StudentForm;
import cherry.dto.student.StudentResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StudentMapper {

    Student toStudent(StudentForm studentForm);

    StudentResponse toStudentResponse(Student student);

    Address toAddress(StudentForm.StudentAddressForm addressForm);

    StudentResponse.StudentAddressResponse toStudentAddressResponse(Address address);
}
