package com.controller_files;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Dao.VoterDao;
import com.Dao.VoterDaoImpl;

@WebServlet("/voterlogin")
public class VoterLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		
		VoterDao voterDao = new VoterDaoImpl();
		
		String passString = request.getParameter("VoterPassword");
		String rollnumber = request.getParameter("RollNo");
		// System.out.println(rollnumber);
		int rollno = Integer.parseInt(rollnumber);
		
		
			int voterstatus = 0;
			try {
				voterstatus = voterDao.getvoterstatus(rollno);
		System.out.println(voterstatus);
		
		
		if (voterstatus == 0) {

			try {
				if (voterDao.authenticateVoter(rollno, passString)) {

					HttpSession session = request.getSession();
					session.setAttribute("RollNo", rollnumber);

					HttpSession session2 = request.getSession();
					session2.setAttribute("PassString", passString);

					response.sendRedirect("vote.jsp?VoterId=" + rollno);
				} else {
					response.sendRedirect("voter_login.jsp?Message=User Does not exixt Register First");

				}
			} catch (ClassNotFoundException | SQLException e) {
				response.sendRedirect("voter_login.jsp?Message=User Does not exixt Register First");

				e.printStackTrace();
			}
		}
		
		

		else {
			response.sendRedirect("voter_login.jsp?Message=Already voted can't vote again");

		}
			} catch (ClassNotFoundException | SQLException e1) {
				response.sendRedirect("voter_login.jsp?Message=Already voted can't vote again");

				e1.printStackTrace();
			}
		
	}

}
