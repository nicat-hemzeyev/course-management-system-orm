package az.example.coursemanagementorm.dao.repository;

import az.example.coursemanagementorm.dao.entity.StudentEntity;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<StudentEntity, Long> {

}
