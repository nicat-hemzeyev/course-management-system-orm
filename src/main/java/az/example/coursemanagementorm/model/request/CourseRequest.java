package az.example.coursemanagementorm.model.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class CourseRequest {
    private String name;
    private String description;
    private Integer duration;
    private Double price;
    private Long teacherId;
    private List<Long> studentIds;

}
