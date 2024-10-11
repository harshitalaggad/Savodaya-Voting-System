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

@WebServlet("/vote")
public class Vote extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String vId = request.getParameter("voterRollno");
		// System.out.println(vId);
		int Rollno = Integer.valueOf(vId);
		String cId = request.getParameter("candidateSno");
		int candidateSno = Integer.valueOf(cId);
		// System.out.println(candidateSno);

		try {
			VoterDao voterDao = new VoterDaoImpl();
			int status = voterDao.updatevoterstatus(Rollno);
			int votes = voterDao.updatecandidatevotes(candidateSno);
			System.out.println(votes);
			if (status > 0 && votes > 0) {
				HttpSession session= request.getSession();
				session.removeAttribute("RollNo");
				HttpSession session2= request.getSession();
				session2.removeAttribute("VoterPassword");//is the parameters right
				session.invalidate();
				response.sendRedirect("voter_login.jsp?Message= Thanks For Voting");
				
			} else {
				response.sendRedirect("vote.jsp?Message= Can't Vote Try Again!");

			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}

}
