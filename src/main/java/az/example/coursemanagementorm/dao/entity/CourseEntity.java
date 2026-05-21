package az.example.coursemanagementorm.dao.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "courses")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class CourseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    private String description;
    private Integer duration; //kursun muddeti
    private Double price; //kursun qiymeti
    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private TeacherEntity teacher;
    @OneToMany(mappedBy = "course")
    private List<EnrollmentEntity> enrollment = new ArrayList<>();
    private LocalDateTime createdAt; // hem tarix hem saat saxlayir

    @PrePersist
    protected void onCreate(){
        createdAt=LocalDateTime.now();
    }
}
