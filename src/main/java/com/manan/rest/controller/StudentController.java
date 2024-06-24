package com.manan.rest.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.manan.rest.entity.Student;
import com.manan.rest.errorresponse.StudentNotFoundException;

import jakarta.annotation.PostConstruct;

@RestController
@RequestMapping("/api")
public class StudentController {
	
	List<Student> students=new ArrayList<>();
	
	@PostConstruct
	public void LoadData()
	{
		students.add(new Student(0,"Akash","A"));
		students.add(new Student(1,"Jackson","Conely"));
		students.add(new Student(2,"Kevin","Andrews"));
	}
	
	//Retrieve all students
	@GetMapping("/students")
	public List<Student> getStudents() throws StudentNotFoundException
	{
		if(students.size()==0 || students.isEmpty())
		{
			throw new StudentNotFoundException("No students available!");
		}
		return students;
	}
	
	//Retrieve student by id
	@GetMapping("/students/{studentId}")
	public Student getStudentById(@PathVariable Integer studentId) throws StudentNotFoundException
	{
		if(studentId>=students.size()||studentId<0)
		{
			throw new StudentNotFoundException("Student Id is not found! "+studentId);
		}
		return students.get(studentId);
		
	}

}
