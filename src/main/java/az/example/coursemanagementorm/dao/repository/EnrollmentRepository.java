package az.example.coursemanagementorm.dao.repository;

import az.example.coursemanagementorm.dao.entity.CourseEntity;
import az.example.coursemanagementorm.dao.entity.EnrollmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnrollmentRepository extends JpaRepository<EnrollmentEntity, Long> {

    boolean existsByStudent_IdAndCourse_Id(Long studentId, Long courseId);

    void deleteByStudent_IdAndCourse_Id(Long studentId, Long courseId);

}
