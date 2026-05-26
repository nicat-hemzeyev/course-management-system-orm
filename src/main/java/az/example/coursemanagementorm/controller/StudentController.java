package az.example.coursemanagementorm.controller;

import az.example.coursemanagementorm.model.request.StudentRequest;
import az.example.coursemanagementorm.model.response.StudentResponse;
import az.example.coursemanagementorm.service.StudentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/students")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Yeni Tələbə yarat!")
    @ApiResponse(responseCode = "201", description = "Yeni tələbə yaradıldı!")
    public StudentResponse createStudent(@RequestBody StudentRequest studentRequest) {
        return studentService.createStudent(studentRequest);
    }

    @GetMapping
    @Operation(summary = "Bütün tələbələri göstər!", description = "Bütün tələbələri göstərmək üçündür")
    public List<StudentResponse> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/id/{id}")
    @Operation(summary = "İd-yə görə tələbəni göstər!")
    public StudentResponse getStudentById(@PathVariable Long id){
        return studentService.getStudentById(id);
    }

    @GetMapping("/name/{name}")
    @Operation(summary = "Adına görə tələbəni tap!")
    public List<StudentResponse> getStudentsByName(@PathVariable String name){
        return studentService.getStudentByName(name);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Tələbəni yenilə!", description = "İd-yə görə istədiyiniz tələbənin məlumatlarını yeniləyə bilərsiz")
    public StudentResponse updateStudent(@PathVariable Long id,
                                         @RequestBody StudentRequest studentRequest) {
        return studentService.updateStudent(id, studentRequest);
    }

    @DeleteMapping("/{id}")
        @Operation(summary = "Tələbəni sil!", description = "İd-ye göre tələbəni silə bilərsiz")
    public void deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
    }
}