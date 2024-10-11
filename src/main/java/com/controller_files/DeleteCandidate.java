package com.controller_files;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Dao.AdminDao;
import com.Dao.AdminDaoImpl;

@WebServlet("/deletecandidate")
public class DeleteCandidate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		AdminDao adminDao = new AdminDaoImpl();
		String sno = request.getParameter("Sno");
		int SNo = Integer.parseInt(sno);
		
		try {
			int result =adminDao.deletecandidate(SNo);

			if (result>0) {
                    response.sendRedirect("candidate_list.jsp?Message=Candidate Deleted");
			}else {
                response.sendRedirect("edit_candidate.jsp?Message=Candidate Can't Deleted");

			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}

}
