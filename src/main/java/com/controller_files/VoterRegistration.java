package com.controller_files;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Dao.VoterDao;
import com.Dao.VoterDaoImpl;
import com.pojo.Voter;

@WebServlet("/voterregistration")
public class VoterRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String FirstName = request.getParameter("firstname");
		String LastName = request.getParameter("lastname");
		String Gender = request.getParameter("gender");
		String Date = request.getParameter("dob");
		LocalDate Dob = LocalDate.parse(Date);	
		String Branch = request.getParameter("branch");
		String Year = request.getParameter("year");
		String rollno = request.getParameter("rollno");
		int RollNo= Integer.parseInt(rollno);
		String Password = request.getParameter("password");
		System.out.println(FirstName);

		Voter voter = new Voter();
		voter.setFirstName(FirstName);
		voter.setLastName(LastName);
		voter.setGender(Gender);
		voter.setDob(Dob);
		voter.setBranch(Branch);
		voter.setYear(Year);
		voter.setRollNo(RollNo);
		voter.setVoterPassword(Password);
		System.out.println(voter);
		
		
		
		try {
			VoterDao voterDao= new VoterDaoImpl();
			int result =voterDao.addvoter(voter);
			if (result > 0) {
				response.sendRedirect("voter_login.jsp?Message= Voter Added Succesfully");
			} else {
				response.sendRedirect("voter_registration.jsp?Message= Voter Can't Be Added");

			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		
		
		
	}

}
