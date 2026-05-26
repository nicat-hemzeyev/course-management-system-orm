package az.example.coursemanagementorm.model.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Schema(description = "Kursun məlumatlarını daxil edin!")
public class CourseRequest {
    @Schema(description = "Kursuna adı")
    private String name;
    @Schema(description = "Kurs haqqında məlumat")
    private String description;
    @Schema(description = "Kursun müddəti", example = "3")
    private Integer duration;
    @Schema(description = "Kursun qiyməti")
    private Double price;
    @Schema(description = "Kursa dərs keçəcək müəllimin İd-si")
    private Long teacherId;

}
