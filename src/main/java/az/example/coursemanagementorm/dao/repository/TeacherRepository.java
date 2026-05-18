package az.example.coursemanagementorm.dao.repository;

import az.example.coursemanagementorm.dao.entity.TeacherEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<TeacherEntity, Long> {
}
