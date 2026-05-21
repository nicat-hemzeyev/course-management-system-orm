package az.example.coursemanagementorm.dao.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "teachers")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class TeacherEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String surname;
    @Column(nullable = false, unique = true /*həmin field database-də təkrar ola bilməz.*/)
    private String email;
    private String specialization;//müəllimin hansı sahədə ixtisaslaşdığını göstərir. məsələn Java, Database, Spring
    @OneToMany(mappedBy = "teacher")
    private List<CourseEntity> course = new ArrayList<>();
    private LocalDateTime createdAt;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }
}
