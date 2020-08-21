package com.example.demo.controller;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.School;
import com.example.demo.model.Student;
import com.example.demo.service.SchoolStudentService;

@RestController
public class SchoolController {
	private SchoolStudentService schoolStudentService;

	@GetMapping("/schools/{schoolId}")
	public ResponseEntity<Iterable<Student>> getStudentBySchoolID(@PathVariable("schoolId") Integer schoolId) {
		Optional<School> school = schoolStudentService.findBySchoolId(schoolId);

		return ResponseEntity.ok().body(school.get().getStudents());
	}

	public SchoolController(SchoolStudentService schoolStudentService) {
		this.schoolStudentService = schoolStudentService;
	}

	@RequestMapping(value = "/schools", method = RequestMethod.POST, consumes = { "application/JSON" })
	public ResponseEntity<School> createSchool(@RequestBody School school) {

		return new ResponseEntity<>(schoolStudentService.createSchool(school), HttpStatus.CREATED);
	}
}
