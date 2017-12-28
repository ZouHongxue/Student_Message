package com.ms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ms.bean.Student;
import com.ms.dao.StudentDao;

@Service
public class StudentService {
	
	@Autowired
	StudentDao studentDao;
	
	public List<Student> getAllStudents(){
		return studentDao.getAllStudents();
	}
	
	public boolean addStudent(Student student){
		int i = studentDao.addStudent(student);
		if (i>0) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean alterStudent(Student student){
		if (studentDao.isExists(student.getId())) {
			if(studentDao.alterStudent(student)>0){
				return true;
			}
		}
		return false;
	}
	
	public boolean delStudent(String id){
		if (studentDao.delStudent(id)>0) {
			return true;
		}else {
			return false;
		}
	}
}
