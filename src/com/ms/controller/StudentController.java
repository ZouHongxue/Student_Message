package com.ms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ms.bean.Student;
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
	public String toStudentList(Model model){
		model.addAttribute("students", studentService.getAllStudents());
		return "student";
	}
	
	@RequestMapping("/toAddStudent")
	public String toAddStudent(){
		return "addstudent";
	}
	
	@RequestMapping("/toAltStudent")
	public String toAlterStudent(){
		return "alterstudent";
	}
	
	@RequestMapping("/toDelStudent")
	public String toDelStudent() {
		return "delstudent";
	}
	
	@RequestMapping(value="/addStudent",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String addStudent(Student student){
		if (studentService.addStudent(student)) {
			return "添加成功";
		}else {
			return "添加失败";
		}
	}
	
	
	@RequestMapping(value="/alterStudent",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String alterStudent(Student student){
		if (studentService.alterStudent(student)) {
			return "修改成功";
		}else {
			return "修改失败";
		}
	}
	
	@ResponseBody
	@RequestMapping(value="/delStudent",produces="text/html;charset=UTF-8")
	public String delStudent(String id){
		if (studentService.delStudent(id)) {
			return "删除成功";
		}else {
			return "删除失败";
		}
	}
}
