package az.example.coursemanagementorm.controller;

import az.example.coursemanagementorm.model.request.TeacherRequest;
import az.example.coursemanagementorm.model.response.TeacherResponse;
import az.example.coursemanagementorm.service.TeacherService;
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
    public TeacherResponse createTeacher(@RequestBody TeacherRequest teacherRequest) {
        return teacherService.createTeacher(teacherRequest);
    }

    @GetMapping
    public List<TeacherResponse> getAllTeachers() {
        return teacherService.getAllTeachers();
    }

    @GetMapping("/{id}")
    public TeacherResponse getTeacherById(@PathVariable Long id) {
        return teacherService.getTeacherById(id);
    }

    @GetMapping("/{name}")
    public TeacherResponse getTeacherByName(@PathVariable String name) {
        return teacherService.getTeacherByName(name);
    }

    @PutMapping("/{id}")
    public TeacherResponse updateTeacher(@PathVariable Long id,
                                         @RequestBody TeacherRequest teacherRequest) {
        return teacherService.updateTeacher(id, teacherRequest);
    }

    @DeleteMapping("/{id}")
    public void deleteTeacher(@PathVariable Long id) {
        teacherService.deleteTeacher(id);
    }
}
