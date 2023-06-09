package student.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import student.entity.Student;
import student.service.StudentService;

@RestController
@RequestMapping("/api/v1/students")
@RequiredArgsConstructor
public class StudentController {

	private final StudentService studentService;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void save(@RequestBody Student student) {
		studentService.saveStudent(student);
	}
	
	@GetMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<List<Student>>findAllStudents () {
		return ResponseEntity.ok(studentService.findAllStudents());
	}
	
	@GetMapping("/school/{school-id}")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<List<Student>>findAl(@PathVariable("school-id") Integer schoolId) {
		return ResponseEntity.ok(studentService.findAllStudentsBySchool(schoolId));
	}
}
