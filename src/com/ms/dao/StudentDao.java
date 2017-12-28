package com.ms.dao;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

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
}
