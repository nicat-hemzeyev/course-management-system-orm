package az.example.coursemanagementorm.service;

import az.example.coursemanagementorm.dao.entity.TeacherEntity;
import az.example.coursemanagementorm.dao.repository.TeacherRepository;
import az.example.coursemanagementorm.mapper.TeacherMapper;
import az.example.coursemanagementorm.model.request.TeacherRequest;
import az.example.coursemanagementorm.model.response.TeacherResponse;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherService {
    private final TeacherRepository teacherRepository;

    public TeacherResponse createTeacher(TeacherRequest teacherRequest) {
        TeacherEntity teacherEntity = TeacherMapper.mapToEntity(teacherRequest);
        TeacherEntity teacher = teacherRepository.save(teacherEntity);
        return TeacherMapper.mapToResponse(teacher);
    }

    public List<TeacherResponse> getAllTeachers() {
        return teacherRepository.findAll()
                .stream()
                .map(TeacherMapper::mapToResponse)
                .toList();
    }

    public TeacherResponse getTeacherById(Long id) {
        return teacherRepository.findById(id)
                .map(TeacherMapper::mapToResponse)
                .orElseThrow(() -> new RuntimeException("not found teacher: " + id));
    }

    public TeacherResponse getTeacherByName(String name) {
        return teacherRepository.findByName(name)
                .map(TeacherMapper::mapToResponse)
                .orElseThrow(() -> new RuntimeException("not found teacher: " + name));

    }

    public TeacherResponse updateTeacher(Long id, TeacherRequest teacherRequest) {
        TeacherEntity teacher = teacherRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("not found teacher: " + id));

        teacher.setName(teacherRequest.getName());
        teacher.setSurname(teacherRequest.getSurname());
        teacher.setEmail(teacherRequest.getEmail());
        teacher.setSpecialization(teacherRequest.getSpecialization());
        TeacherEntity updated =teacherRepository.save(teacher);
        return TeacherMapper.mapToResponse(updated);
    }

    @Transactional
    public void deleteTeacher(Long id){
        teacherRepository.deleteById(id);
    }

}
