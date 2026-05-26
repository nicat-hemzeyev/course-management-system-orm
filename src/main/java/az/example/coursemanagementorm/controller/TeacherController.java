package az.example.coursemanagementorm.controller;

import az.example.coursemanagementorm.model.request.TeacherRequest;
import az.example.coursemanagementorm.model.response.TeacherResponse;
import az.example.coursemanagementorm.service.TeacherService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/teachers")
@RequiredArgsConstructor
public class TeacherController {
    private final TeacherService teacherService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Yeni müəllim yarat!")
    @ApiResponse(responseCode = "201", description = "Yeni müəllim yaradıldı!")
    public TeacherResponse createTeacher(@RequestBody TeacherRequest teacherRequest) {
        return teacherService.createTeacher(teacherRequest);
    }

    @GetMapping
    @Operation(summary = "Bütün müəllimləri göstər!", description = "Bütün müəllimləri göstərmək üçündür")
    public List<TeacherResponse> getAllTeachers() {
        return teacherService.getAllTeachers();
    }

    @GetMapping("/id/{id}")
    @Operation(summary = "İd-yə görə müəllimi göstər!")
    public TeacherResponse getTeacherById(@PathVariable Long id) {
        return teacherService.getTeacherById(id);
    }

    @GetMapping("/name/{name}")
    @Operation(summary = "Adına görə müəllimi tap!")
    public TeacherResponse getTeacherByName(@PathVariable String name) {
        return teacherService.getTeacherByName(name);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Müəllimi yenilə!", description = "İd-yə görə istədiyiniz müəllimin məlumatlarını yeniləyə bilərsiz")
    public TeacherResponse updateTeacher(@PathVariable Long id,
                                         @RequestBody TeacherRequest teacherRequest) {
        return teacherService.updateTeacher(id, teacherRequest);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Müəllimi sil!", description = "İd-ye göre müəllimi silə bilərsiz")
    public void deleteTeacher(@PathVariable Long id) {
        teacherService.deleteTeacher(id);
    }
}
