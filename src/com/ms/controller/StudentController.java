package com.ms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ms.service.StudentService;

@Controller
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	StudentService studentService;
	
	@RequestMapping("/getAllStudents")
	public String getAllStudents(Model model){
		model.addAttribute("students", studentService.getAllStudents());
		return "s_show";
	}
	
	@RequestMapping("/toStudentList")
	public String toStudentList(){
		return "student";
	}
}
