package az.example.coursemanagementorm.dao.repository;

import az.example.coursemanagementorm.dao.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, Long> {

  //  Optional<StudentEntity> findByEmail(String email);

    List<StudentEntity> findByName(String name);

  //  boolean existsByEmail(String email);

   // Optional<StudentEntity> updateStudent(Long id, StudentEntity studentEntity);

   // void deleteByEmail(String email);

  //  List<StudentEntity> findByAgeGreaterThan(Integer age);
}
