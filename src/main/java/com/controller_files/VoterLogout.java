package com.controller_files;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/voterlogout")
public class VoterLogout extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session= request.getSession();
		session.removeAttribute("RollNo");
		HttpSession session2= request.getSession();
		session2.removeAttribute("VoterPassword");//is the parameters right
		session.invalidate();
		//session2.invalidate();
		response.sendRedirect("voter_login.jsp?Message= Logged Out Successfully");
		
		
		
	}
	
}
