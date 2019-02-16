package com.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.dao.StudentDao;
import com.example.util.Util;
import com.model.Student;

public class StudentDaoImpl implements StudentDao {
	
	private Connection conn;

	public StudentDaoImpl() {
		conn = Util.getConnection();
}

	@Override
	public void addStudent(String name, String roll) {

		try {
			PreparedStatement preparedstatement = conn.prepareStatement("insert into student(name,roll) values(? , ?)");
			preparedstatement.setString(1, name);
			preparedstatement.setString(2, roll);
			preparedstatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void deleteStudent(String id) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement preparedstatement = conn.prepareStatement("delete from student where id= ?");
			preparedstatement.setInt(1,Integer.parseInt(id));
			 preparedstatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<Student> listStudent() {
		// TODO Auto-generated method stub
		List<Student> studentData = new ArrayList<Student>();
		try {
			Statement statement = conn.createStatement();
			ResultSet resultSet = statement.executeQuery( "select * from student" );
			while( resultSet.next() ) {
				Student student = new Student();
				student.setId(String.valueOf(resultSet.getInt( "id" ) ));
				student.setName( resultSet.getString( "name" ) );
				student.setRoll( resultSet.getString( "roll" ) );
				studentData.add(student);
			}
			resultSet.close();
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return studentData;
	}

	@Override
	public void updateStudent(String id, String name, String roll) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement ps = conn.prepareStatement("update student set name=?,roll=? where id=?");
			ps.setString(1, name);
			ps.setString(2, roll);
			ps.setInt(3, Integer.parseInt(id));
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Student> editStudent(String id) {
		// TODO Auto-generated method stub
		List<Student> data = new ArrayList<Student>();
		try {
			PreparedStatement preparedStatement = conn.prepareStatement("select * from student where id= ?");
            // Parameters start with 1
            preparedStatement.setString(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
			while( resultSet.next() ) {
				Student student = new Student();
				student.setId( String.valueOf(resultSet.getInt( "id" )) );
				student.setName( resultSet.getString( "name" ) );
				student.setRoll( resultSet.getString( "roll" ) );
				data.add(student);
			}
			resultSet.close();
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return data;
	}


}
