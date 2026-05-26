package az.example.coursemanagementorm.controller;

import az.example.coursemanagementorm.model.request.CourseRequest;
import az.example.coursemanagementorm.model.response.CourseResponse;
import az.example.coursemanagementorm.service.CourseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/courses")
@RequiredArgsConstructor
public class CourseController {
    private final CourseService courseService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Yeni kurs yarat!")
    @ApiResponse(responseCode = "201",description = "Kurs yaradildi")
    public CourseResponse createCourse(@RequestBody CourseRequest courseRequest) {
        return courseService.createCourse(courseRequest);
    }

    @GetMapping
    @Operation(summary = "Bütün kursları göstər!", description = "Bütün kursları göstərmək üçündür")
    public List<CourseResponse> getAllCourses() {
        return courseService.getAllCourses();
    }

    @GetMapping("/{id}")
    @Operation(summary = "İd-yə görə kursu göstər!")
    public CourseResponse getCourseById(@PathVariable Long id) {
        return courseService.getCourseById(id);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Kursu yenilə!", description = "İd-yə görə istədiyiniz kursun məlumatlarını yeniləyə bilərsiz")
    public CourseResponse updateCourse(@PathVariable Long id, @RequestBody CourseRequest courseRequest) {
        return courseService.updateCourse(id, courseRequest);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Kursu sil!", description = "İd-ye göre kursu silə bilərsiz")
    public void deleteCourse(@PathVariable Long id) {
        courseService.deleteCourse(id);
    }
}
