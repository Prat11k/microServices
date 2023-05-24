package school.service;

import java.util.List;

import org.springframework.stereotype.Service;

import school.client.StudentClient;
import school.entity.FullSchoolResponse;
import school.entity.School;
import school.repository.SchoolRepository;
import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class SchoolService {
	
	private final SchoolRepository schoolRepository;
	private final StudentClient studentClient;
	
	public void saveSchool(School School) {
		schoolRepository.save(School);
	}
	public List<School> findAllSchools(){
		return schoolRepository.findAll();
	}
	public FullSchoolResponse findSchoolsWithStudents(Integer schoolId) {
		var school = schoolRepository.findById(schoolId)
                .orElse(School.builder()
                               .name("NOT_FOUND")
                               .email("NOT_FOUND")
                               .build());
        var students = studentClient.findAllStudentsBySchool(schoolId);
        return FullSchoolResponse.builder()
                .name(school.getName())
                .email(school.getEmail())
                .students(students)
                .build();
    }
	
}
