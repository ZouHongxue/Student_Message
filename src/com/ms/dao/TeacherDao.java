package com.ms.dao;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.stereotype.Repository;

import com.ms.bean.Teacher;
import com.ms.util.JdbcUtil;

@Repository
public class TeacherDao {
	
	public List<Teacher> getTeacher(String username){
		QueryRunner runner = new QueryRunner(JdbcUtil.getDataSource());
		String sql ="select * from teacher where name = ? ";
		Object[] params = {username};
		List<Teacher> list= null;
		try {
			list = runner.query(sql, new BeanListHandler<Teacher>(Teacher.class),params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public List<Teacher> getAllTeachers(){
		QueryRunner runner = new QueryRunner(JdbcUtil.getDataSource());
		String sql ="select * from teacher";
		List<Teacher> list= null;
		try {
			list = runner.query(sql, new BeanListHandler<Teacher>(Teacher.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public int addTeacher(Teacher teacher){
		QueryRunner runner = new QueryRunner(JdbcUtil.getDataSource());
		String sql = "insert into teacher values (?,?)";
		int i = 0;
		Object[] params = {teacher.getName(),teacher.getPwd()};
		try {
			i = runner.execute(sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}
}
