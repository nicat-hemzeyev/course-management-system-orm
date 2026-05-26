package az.example.coursemanagementorm.controller;

import az.example.coursemanagementorm.service.EnrollmentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/enrollments")
@RequiredArgsConstructor
public class EnrollmentController {
    private final EnrollmentService enrollmentService;

    @PostMapping("/{studentId}/enroll/{courseId}")
    @Operation(summary = "Tələbəni kursa yaz!")
    @ApiResponse(responseCode ="200",description = "Tələbə kursa yazıldı!")
    public void enrollStudentToCourse(@PathVariable Long studentId,
                                      @PathVariable Long courseId) {
        enrollmentService.enrollStudentToCourse(studentId, courseId);
    }

    @DeleteMapping("/{studentId}/unenroll/{courseId}")
    @Operation(summary = "Tələbəni kursdan sil!")
    @ApiResponse(responseCode = "200",description = "Tələbə kursdan silindi!")
    public void unenrollStudentFromCourse(@PathVariable Long studentId,
                                          @PathVariable Long courseId) {
        enrollmentService.unenrollStudentFromCourse(studentId, courseId);
    }
}
