package az.example.coursemanagementorm.model.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class StudentRequest {
    private String name;
    private String surname;
    private String email;
    private Integer age;

}
