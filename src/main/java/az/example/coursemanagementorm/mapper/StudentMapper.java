package az.example.coursemanagementorm.mapper;

import az.example.coursemanagementorm.dao.entity.StudentEntity;
import az.example.coursemanagementorm.model.request.StudentRequest;
import az.example.coursemanagementorm.model.response.StudentResponse;

public class StudentMapper {

    public static StudentEntity mapToEntity(StudentRequest studentRequest) {
        return StudentEntity.builder()
                .name(studentRequest.getName())
                .surname(studentRequest.getSurname())
                .email(studentRequest.getEmail())
                .age(studentRequest.getAge())
                .build();
    }
    public static StudentResponse mapToResponse(StudentEntity studentEntity){
        return StudentResponse.builder()
                .id(studentEntity.getId())
                .name(studentEntity.getName())
                .surname(studentEntity.getSurname())
                .email(studentEntity.getEmail())
                .age(studentEntity.getAge())
                .createdAt(studentEntity.getCreatedAt())
                .build();
    }
}
