package az.example.coursemanagementorm.model.response;

import az.example.coursemanagementorm.dao.entity.EnrollmentEntity;
import az.example.coursemanagementorm.dao.entity.TeacherEntity;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class CourseResponse {
    private Long id;
    private String name;
    private String description;
    private Integer duration;
    private Double price;
    private TeacherResponse teacher;
    private List<StudentResponse> students;
    private LocalDateTime createdAt;
}
