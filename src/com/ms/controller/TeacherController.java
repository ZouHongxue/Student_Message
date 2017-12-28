package com.ms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ms.bean.Teacher;
import com.ms.service.TeacherService;

@Controller
@RequestMapping("/teacher")
public class TeacherController {
	
	@Autowired
	TeacherService teacherService;
	
	@RequestMapping("/login")
	public String userLogin(Teacher teacher,Model model){
		boolean type = teacherService.userLogin(teacher);
		if (type) {
			model.addAttribute("teachers", teacherService.getAllTeachers());
			return "home";
		}else {
			return "login";
		}
	}
	
	@RequestMapping(value="/reg",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String userReg(Teacher teacher){
		if (teacherService.addTeacher(teacher)) {
			return "注册成功";
		}else {
			return "注册失败";
		}
	}
	
	@RequestMapping("/toHome")
	public String toHome(Model model){
		model.addAttribute("teachers", teacherService.getAllTeachers());
		return "home";
	}
}
