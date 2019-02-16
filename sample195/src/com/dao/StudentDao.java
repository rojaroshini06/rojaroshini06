package com.dao;

import java.util.List;

import com.model.Student;

public interface StudentDao  {
	
	void addStudent(String name, String roll);


	void deleteStudent(String id);


	List<Student> listStudent();


	void updateStudent(String id, String name, String roll);


     List<Student> editStudent(String id);




	

}
