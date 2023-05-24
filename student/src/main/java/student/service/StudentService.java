package student.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import student.entity.Student;
import student.repository.StudentRepository;

@Service
@RequiredArgsConstructor
public class StudentService {
	
	private final StudentRepository studentRepository;
	
	public void saveStudent(Student student) {
		studentRepository.save(student);
	}
	public List<Student> findAllStudents(){
		return studentRepository.findAll();
	}
	public List<Student> findAllStudentsBySchool(Integer schoolId) {
		// TODO Auto-generated method stub
		return studentRepository.findAllBySchoolId(schoolId);
	}
}
