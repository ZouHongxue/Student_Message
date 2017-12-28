package com.ms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ms.bean.Teacher;
import com.ms.dao.TeacherDao;

@Service
public class TeacherService {
	
	@Autowired
	TeacherDao teacherDao;
	
	public boolean userLogin(Teacher teacher){
		if(teacher.getName()==null && teacher.getPwd() == null)
			return false;
		List<Teacher> list = teacherDao.getTeacher(teacher.getName());
		if (list==null) {
			return false;
		}
		for(Teacher t:list){
			if (teacher.getPwd().equals(t.getPwd())) {
				return true;
			}
		}
		return false;
	}
	
	public List<Teacher> getAllTeachers(){
		return teacherDao.getAllTeachers();
	}
	
	public boolean addTeacher(Teacher teacher){
		if(teacherDao.addTeacher(teacher)>0){
			return true;
		}else {
			return false;
		}
	}
}
