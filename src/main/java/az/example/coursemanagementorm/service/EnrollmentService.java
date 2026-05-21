package az.example.coursemanagementorm.service;

import az.example.coursemanagementorm.dao.entity.CourseEntity;
import az.example.coursemanagementorm.dao.entity.EnrollmentEntity;
import az.example.coursemanagementorm.dao.entity.StudentEntity;
import az.example.coursemanagementorm.dao.repository.CourseRepository;
import az.example.coursemanagementorm.dao.repository.EnrollmentRepository;
import az.example.coursemanagementorm.dao.repository.StudentRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EnrollmentService {
    private final EnrollmentRepository enrollmentRepository;
    private final CourseRepository courseRepository;
    private final StudentRepository studentRepository;

    public void enrollStudentToCourse(Long studentId, Long courseId) {
        StudentEntity studentEntity = studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found: " + studentId));
        CourseEntity courseEntity = courseRepository.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Course not found: " + courseId));

        if (enrollmentRepository.existsByStudent_IdAndCourse_Id(studentId, courseId)) {
            throw new RuntimeException("Student already enrolled in this course");
        }
        EnrollmentEntity enrollmentEntity = new EnrollmentEntity();
        enrollmentEntity.setStudent(studentEntity);
        enrollmentEntity.setCourse(courseEntity);

        enrollmentRepository.save(enrollmentEntity);
    }

    @Transactional
    public void unenrollStudentFromCourse(Long studentId, Long courseId) {
        if (!enrollmentRepository.existsByStudent_IdAndCourse_Id(studentId, courseId)) {
            throw new RuntimeException("Enrollment not found");
        }
         enrollmentRepository.deleteByStudent_IdAndCourse_Id(studentId, courseId);
    }
}
