package com.controller_files;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Dao.AdminDao;
import com.Dao.AdminDaoImpl;

@WebServlet("/adminlogin")
public class AdminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userName = request.getParameter("AdminId");
     	String password = request.getParameter("AdminPassword");
		
		
		
			try {
				AdminDao adminDao= new AdminDaoImpl();
			
				if (adminDao.authenticate(userName, password)) {
					
					HttpSession session= request.getSession();
					session.setAttribute("AdminId",userName);
					
					HttpSession session2= request.getSession();
					session2.setAttribute("AdminPassword",password);
					
					response.sendRedirect("welcome_admin.jsp?Message=login Successfully");
				} else {
					response.sendRedirect("admin_login.jsp?Message= Wrong Credentials!");

				}
			} catch (ClassNotFoundException | SQLException | IOException e) {
				e.printStackTrace();
			}
		

		}

		
		
		
	}


