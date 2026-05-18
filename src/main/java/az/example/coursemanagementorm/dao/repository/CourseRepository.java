package az.example.coursemanagementorm.dao.repository;

import az.example.coursemanagementorm.dao.entity.CourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<CourseEntity, Long> {
}
