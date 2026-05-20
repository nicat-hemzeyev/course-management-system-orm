package az.example.coursemanagementorm.model.response;

import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class StudentResponse {
    private Long id;
    private String name;
    private String surname;
    private String email;
    private Integer age;
    private LocalDateTime createdAt;

}
