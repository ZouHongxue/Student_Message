package com.ms.dao;

import java.sql.SQLException;
import java.util.List;


import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.stereotype.Repository;

import com.ms.bean.Student;
import com.ms.util.JdbcUtil;

@Repository
public class StudentDao {
	
	public List<Student> getAllStudents() {
		List<Student> students = null;
		QueryRunner qr = new QueryRunner(JdbcUtil.getDataSource());
		String sql = "select * from student";
		try {
			students = qr.query(sql, new BeanListHandler<Student>(Student.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return students;
	}
	
	public int addStudent(Student student){
		QueryRunner runner = new QueryRunner(JdbcUtil.getDataSource());
		String sql = "insert into student values (?,?,?,?,?)";
		Object[] params = {student.getId(),student.getName(),student.getS_class()
				,student.getSex(),student.getAge()};
		int i = 0;
		try {
			i = runner.execute(sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}
	
	public boolean isExists(String id){
		QueryRunner runner = new QueryRunner(JdbcUtil.getDataSource());
		String sql = "select * from student where id = ?";
		Object[] param = {id};
		List<Student> list = null;
		try {
			list = runner.query(sql,new BeanListHandler<Student>(Student.class), param);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (list.size()>0) {
			return true;
		}
		return false;
	}
	
	public int alterStudent(Student student){
		QueryRunner runner = new QueryRunner(JdbcUtil.getDataSource());
		String sql = "update student set name=?, s_class=?, sex=?, age=? where id=?";
		Object[] params = {student.getName(),student.getS_class(),student.getSex(),
					student.getAge(),student.getId()};
		int i = 0;
		try {
			i = runner.execute(sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}
	
	public int delStudent(String id){
		QueryRunner runner = new QueryRunner(JdbcUtil.getDataSource());
		String sql = "delete from student where id = ?";
		Object[] params = {id};
		int i = 0;
		try {
			i = runner.execute(sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}
}
