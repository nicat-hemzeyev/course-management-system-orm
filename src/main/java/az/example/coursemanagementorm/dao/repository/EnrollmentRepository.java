package az.example.coursemanagementorm.dao.repository;

import az.example.coursemanagementorm.dao.entity.EnrollmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnrollmentRepository extends JpaRepository<EnrollmentEntity, Long> {
}
