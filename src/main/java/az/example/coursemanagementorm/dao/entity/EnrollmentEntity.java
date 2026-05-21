package az.example.coursemanagementorm.dao.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "enrollments")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class EnrollmentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "student_id")
    private StudentEntity student;//student
    @ManyToOne
    @JoinColumn(name = "course_id")
    private CourseEntity course;//course
    private LocalDate enrolledAt; //sadece tarix
    @Enumerated(EnumType.STRING)
    private EnrollmentStatus status;
@PrePersist
    protected void onCreate(){
    enrolledAt=LocalDate.now();
}
}
