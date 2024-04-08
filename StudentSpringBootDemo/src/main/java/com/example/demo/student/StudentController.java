package com.example.demo.student;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping(path="api/v1/student")
public class StudentController {
	
	
	private final StudentService studentService;

	@Autowired
	public StudentController(StudentService studentService) {
		this.studentService = studentService;
	}

	/*@GetMapping
	public List<Student> getStudents() {
		return List.of(new Student(
				                 1L, 
				                 "Mariam", 
				                 "mariam.jamal@gmail.com", 
				                 LocalDate.of(2000, Month.JANUARY, 5),
				                 21));
	}
	*/
	
	@GetMapping("getAllStudents")
	public List<Student> getStudents() {
		
		return studentService.getStudents();
		
	}
	
	@PostMapping("create")
	public void registerNewStudent(@RequestBody Student student) {
		studentService.addNewStudent(student);
	}
	
	@DeleteMapping(path = "{studentId}")
	public void deleteStudent(
			@PathVariable("studentId") Long studentId) {
		studentService.deleteStudent(studentId);
		
	}
	
	@PutMapping(path="{studentId}")
	public void updateStudnet(
			@PathVariable("studentId") Long studentId,
	        @RequestParam(required = false) String name,
	        @RequestParam(required = false) String email) {
		studentService.updateStudent(studentId, name, email);
			
		}
	

}
