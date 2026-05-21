package az.example.coursemanagementorm.controller;

import az.example.coursemanagementorm.service.EnrollmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/enrollments")
@RequiredArgsConstructor
public class EnrollmentController {
    private final EnrollmentService enrollmentService;

    @PostMapping("/{studentId}/enroll/{courseId}")
    public void enrollStudentToCourse(@PathVariable Long studentId,
                                      @PathVariable Long courseId) {
        enrollmentService.enrollStudentToCourse(studentId, courseId);
    }

    @DeleteMapping("/{studentId}/unenroll/{courseId}")
    public void unenrollStudentFromCourse(@PathVariable Long studentId,
                                          @PathVariable Long courseId) {
        enrollmentService.unenrollStudentFromCourse(studentId, courseId);
    }
}
