package az.example.coursemanagementorm.service;

import az.example.coursemanagementorm.dao.entity.CourseEntity;
import az.example.coursemanagementorm.dao.entity.EnrollmentEntity;
import az.example.coursemanagementorm.dao.entity.StudentEntity;
import az.example.coursemanagementorm.dao.entity.TeacherEntity;
import az.example.coursemanagementorm.dao.repository.CourseRepository;
import az.example.coursemanagementorm.dao.repository.EnrollmentRepository;
import az.example.coursemanagementorm.dao.repository.StudentRepository;
import az.example.coursemanagementorm.dao.repository.TeacherRepository;
import az.example.coursemanagementorm.mapper.CourseMapper;
import az.example.coursemanagementorm.model.request.CourseRequest;
import az.example.coursemanagementorm.model.response.CourseResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService {
    private final CourseRepository courseRepository;
    private final StudentRepository studentRepository;
    private final TeacherRepository teacherRepository;
    private final EnrollmentRepository enrollmentRepository;

    public CourseResponse createCourse(CourseRequest courseRequest) {
        //1. mlmi DB-dan tap
        TeacherEntity teacherEntity = teacherRepository.findById(courseRequest.getTeacherId())
                .orElseThrow(() -> new RuntimeException("Teacher not found:" + courseRequest.getTeacherId()));
        // 2. CourseEntity-ni mapper ilə qur
        CourseEntity courseEntity = CourseMapper.mapToEntity(courseRequest, teacherEntity);
        // 3. Kursu DB-yə save et
        courseRepository.save(courseEntity);
        // 4. StudentIds əsasında enrollment yarat
        if (courseRequest.getStudentIds() != null) {
            for (Long studentId : courseRequest.getStudentIds()) {
                StudentEntity studentEntity = studentRepository.findById(studentId)
                        .orElseThrow(() -> new RuntimeException("Student not found: " + studentId));
                EnrollmentEntity enrollmentEntity = new EnrollmentEntity();
                enrollmentEntity.setStudent(studentEntity);
                enrollmentEntity.setCourse(courseEntity);
                enrollmentRepository.save(enrollmentEntity);
            }
        }
        // 5. Response qaytar
        return CourseMapper.mapToResponse(courseEntity);
    }

    public List<CourseResponse> getAllCourses() {
        return courseRepository.findAll()
                .stream()
                .map(CourseMapper::mapToResponse)
                .toList();
    }

    public CourseResponse getCourseById(Long id) {
        return courseRepository.findById(id)
                .map(CourseMapper::mapToResponse)
                .orElseThrow(() -> new RuntimeException("Course not found: " + id));
    }

    public CourseResponse updateCourse(Long id, CourseRequest courseRequest) {
        TeacherEntity teacherEntity = teacherRepository.findById(courseRequest.getTeacherId())
                .orElseThrow(() -> new RuntimeException("Teacher not found:" +
                        courseRequest.getTeacherId()));

        CourseEntity course = courseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Course not found: " + id));
        course.setName(courseRequest.getName());
        course.setDescription(courseRequest.getDescription());
        course.setDuration(courseRequest.getDuration());
        course.setPrice(courseRequest.getPrice());
        course.setTeacher(teacherEntity);
        CourseEntity updated = courseRepository.save(course);
        return CourseMapper.mapToResponse(updated);
    }

    public void deleteCourse(Long id) {
        courseRepository.deleteById(id);
    }
}
