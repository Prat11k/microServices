package school.controller;

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
import school.entity.FullSchoolResponse;
import school.entity.School;
import school.service.SchoolService;

@RestController
@RequestMapping("/api/v1/schools")
@RequiredArgsConstructor
public class SchoolController {

	private final SchoolService schoolService;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void save(@RequestBody School school) {
		schoolService.saveSchool(school);
	}
	
	@GetMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<List<School>>findAllSchools () {
		return ResponseEntity.ok(schoolService.findAllSchools());
	}
	@GetMapping("/withstudents/{school-id}")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<FullSchoolResponse>findAllBySchoolId (@PathVariable("school-id") Integer schoolId) {
		return ResponseEntity.ok(schoolService.findSchoolsWithStudents(schoolId));
	}
}