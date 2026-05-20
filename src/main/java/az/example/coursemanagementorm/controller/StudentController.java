package az.example.coursemanagementorm.controller;

import az.example.coursemanagementorm.model.request.StudentRequest;
import az.example.coursemanagementorm.model.response.StudentResponse;
import az.example.coursemanagementorm.service.StudentService;
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
    public StudentResponse createStudent(@RequestBody StudentRequest studentRequest) {
        return studentService.createStudent(studentRequest);
    }

    @PutMapping("/{id}")
    public StudentResponse updateStudent(@PathVariable Long id,
                                         @RequestBody StudentRequest studentRequest){
        return studentService.updateStudent(id,studentRequest);
    }
    @GetMapping("/{id}")
    public StudentResponse getStudentById(@PathVariable Long id){
        return studentService.getStudentById(id);
    }
    @GetMapping("/{name}")
    public List<StudentResponse> getStudentsByName(@PathVariable String name){
        return studentService.getStudentByName(name);
    }

    @GetMapping
    public List<StudentResponse> getAllStudents() {
        return studentService.getAllStudents();
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
    }

//@PostMapping("/students/{id}/enroll/{courseId}") → enrollStudentToCourse()
//@DeleteMapping("/students/{id}/unenroll/{courseId}") → unenrollStudentFromCourse()

}