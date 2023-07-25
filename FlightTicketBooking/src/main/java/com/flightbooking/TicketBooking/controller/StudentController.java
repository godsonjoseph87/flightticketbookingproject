package com.flightbooking.TicketBooking.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.flightbooking.TicketBooking.bean.Student;
import com.flightbooking.TicketBooking.service.StudentService;

@RestController
public class StudentController {
	@Autowired
	private StudentService studentService;

	@RequestMapping("/student")
	public List<Student> getAllStudents()
	{
		List<Student> students = studentService.getAllStudent();
		return students;
	}
	
	@RequestMapping(method = RequestMethod.POST, value="/student")
	public String addStudent(@RequestBody Student student)
	{
		int classid = student.getClassid();
		String newName = student.getName();
		List<Student> students = studentService.selectStudentByName(newName);
        for (Student eachstudent : students) {
        	String name = eachstudent.getName();
        	int oldclassid = eachstudent.getClassid();
            if(name.equals(newName)) {
            	return "Student Already belongs to class " + oldclassid;
            }
        }
		studentService.addStudent(student);
		return "Successfully Updated";
	}
	
	
	@RequestMapping(method = RequestMethod.PUT, value="/student/{id}")
	public void updateStudent(@PathVariable String id, @RequestBody Student student)
	{
		studentService.updateStudent(id, student);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value="/student/{id}")
	public void DeleteStudent(@PathVariable String id)
	{
		studentService.deleteStudent(id);
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/studentByClass/{id}")
	public List<Student> selectStudentByClass(@PathVariable int id)
	{
		return studentService.selectStudentByClass(id);
	}
}
