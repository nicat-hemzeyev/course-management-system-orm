package az.example.coursemanagementorm.mapper;

import az.example.coursemanagementorm.dao.entity.TeacherEntity;
import az.example.coursemanagementorm.model.request.TeacherRequest;
import az.example.coursemanagementorm.model.response.TeacherResponse;

public class TeacherMapper {
    public static TeacherEntity mapToEntity(TeacherRequest teacherRequest){
        return TeacherEntity.builder()
                .name(teacherRequest.getName())
                .surname(teacherRequest.getSurname())
                .email(teacherRequest.getEmail())
                .specialization(teacherRequest.getSpecialization())
                .build();
    }
    public static TeacherResponse mapToResponse(TeacherEntity teacherEntity){
        return TeacherResponse.builder()
                .id(teacherEntity.getId())
                .name(teacherEntity.getName())
                .surname(teacherEntity.getSurname())
                .email(teacherEntity.getEmail())
                .specialization(teacherEntity.getSpecialization())
                .createdAt(teacherEntity.getCreatedAt())
                .course(teacherEntity.getCourse())
                .build();
    }
}
