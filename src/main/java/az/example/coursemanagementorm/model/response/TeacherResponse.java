package az.example.coursemanagementorm.model.response;

import az.example.coursemanagementorm.dao.entity.CourseEntity;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class TeacherResponse {
    private Long id;
    private String name;
    private String surname;
    private String email;
    private String specialization;
    private LocalDateTime createdAt;
  //  private List<CourseEntity> course = new ArrayList<>();

}
