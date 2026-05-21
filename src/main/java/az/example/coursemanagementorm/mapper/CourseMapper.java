package az.example.coursemanagementorm.mapper;

import az.example.coursemanagementorm.dao.entity.CourseEntity;
import az.example.coursemanagementorm.dao.entity.TeacherEntity;
import az.example.coursemanagementorm.model.request.CourseRequest;
import az.example.coursemanagementorm.model.response.CourseResponse;

import java.util.stream.Collectors;

public class CourseMapper {
    public static CourseEntity mapToEntity(CourseRequest courseRequest, TeacherEntity teacherEntity) {
        return CourseEntity.builder()
                .name(courseRequest.getName())
                .description(courseRequest.getDescription())
                .duration(courseRequest.getDuration())
                .price(courseRequest.getPrice())
                .teacher(teacherEntity)
                .build();
    }

    public static CourseResponse mapToResponse(CourseEntity courseEntity) {
        return CourseResponse.builder()
                .id(courseEntity.getId())
                .name(courseEntity.getName())
                .description(courseEntity.getDescription())
                .duration(courseEntity.getDuration())
                .price(courseEntity.getPrice())
                .teacher(TeacherMapper.mapToResponse(courseEntity.getTeacher()))
                .students(courseEntity.getEnrollment()
                        .stream()
                        .map(enrollmentEntity -> StudentMapper.mapToResponse(enrollmentEntity.getStudent()))
                        .collect(Collectors.toList()))
                .createdAt(courseEntity.getCreatedAt())
                .build();
    }
}
