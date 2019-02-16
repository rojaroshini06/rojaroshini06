package com.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.StudentDao;
import com.daoImpl.StudentDaoImpl;
import com.daoImpl.StudentDaoImpl;
import com.model.Student;

/**
 * Servlet implementation class StudentController
 */
@WebServlet("/StudentController")
public class StudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private StudentDao dao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentController() {
        super();
        dao = new StudentDaoImpl();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String action = request.getParameter( "action" );
		if(action.equals("add")) {
			String name = request.getParameter( "name" );
			String roll = request.getParameter( "roll" );
			dao.addStudent(name,roll);
			RequestDispatcher view = request.getRequestDispatcher("/success.jsp");
			view.forward(request, response);
		}
		else if(action.equals("delete")) {
			String id = request.getParameter("id");
			dao.deleteStudent(id);
			List<Student> data;
			data = dao.listStudent();
			request.setAttribute("student", data );
			RequestDispatcher view = request.getRequestDispatcher("/listStudent.jsp");
			view.forward(request, response);
			
		}
		else if(action.equals("list")) {
			List<Student> data;
			data = dao.listStudent();
			request.setAttribute("student", data );
			RequestDispatcher view = request.getRequestDispatcher("/listStudent.jsp");
			view.forward(request, response);
		}
		 else if(action.equals("update")) {
				String id = request.getParameter("id");
				String name = request.getParameter( "name" );
				String roll = request.getParameter( "roll" );
				
				dao.updateStudent(id,name,roll);
				List<Student> data;
				data = dao.listStudent();
				request.setAttribute("student", data );
				RequestDispatcher view = request.getRequestDispatcher("/listStudent.jsp");
				view.forward(request, response);
		 }
		 else if(action.equals("edit")) {
			 String id = request.getParameter( "id" );
				List<Student> data = dao.editStudent(id);
				request.setAttribute("student", data );
				RequestDispatcher view = request.getRequestDispatcher("/editStudent.jsp");
				view.forward(request, response);
		 }
				
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
