package az.example.coursemanagementorm.service;

import az.example.coursemanagementorm.dao.entity.StudentEntity;
import az.example.coursemanagementorm.dao.repository.StudentRepository;
import az.example.coursemanagementorm.mapper.StudentMapper;
import az.example.coursemanagementorm.model.request.StudentRequest;
import az.example.coursemanagementorm.model.response.StudentResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentResponse createStudent(StudentRequest studentRequest) {
        StudentEntity studentEntity = StudentMapper.mapToEntity(studentRequest);
        StudentEntity student = studentRepository.save(studentEntity);
        StudentResponse studentResponse = StudentMapper.mapToResponse(student);
        return studentResponse;
    }

    public StudentResponse getStudentById(Long id) {
        return studentRepository.findById(id)
                .map(StudentMapper::mapToResponse)
                .orElseThrow(() -> new RuntimeException("not found id: " + id));
    }

    public List<StudentResponse> getStudentByName(String name) {
        return studentRepository.findByName(name)
                .stream()
                .map(StudentMapper::mapToResponse)
                .toList();
    }

//    public StudentResponse updateStudent(Long id, StudentRequest studentRequest) {
//        StudentEntity studentEntity = StudentMapper.mapToEntity(studentRequest);
//        return studentRepository.updateStudent(id, studentEntity)
//                .map(StudentMapper::mapToResponse)
//                .orElseThrow(() -> new RuntimeException("not found id: " + id));
//    }

    public StudentResponse updateStudent(Long id, StudentRequest studentRequest) {
        StudentEntity student = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("not found id: " + id));

        student.setName(studentRequest.getName());
        student.setSurname(studentRequest.getSurname());
        student.setAge(studentRequest.getAge());
        student.setEmail(studentRequest.getEmail());
        StudentEntity updated = studentRepository.save(student);
        return StudentMapper.mapToResponse(updated);
    }

    public List<StudentResponse> getAllStudents() {
        return studentRepository.findAll()
                .stream()
                .map(StudentMapper::mapToResponse)
                .toList();
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

//    public void enrollStudentToCourse(Long studentId, Long courseId) {
//    }
//
//    public void unenrollStudentFromCourse(Long studentId, Long courseId) {
//    }
}
