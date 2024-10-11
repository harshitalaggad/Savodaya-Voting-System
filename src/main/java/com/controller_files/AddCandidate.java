package com.controller_files;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.Dao.AdminDao;
import com.Dao.AdminDaoImpl;
import com.pojo.Candidate;

@MultipartConfig(maxFileSize = 1600000)
@WebServlet("/addcandidate")
public class AddCandidate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String FirstName = request.getParameter("firstname");
		String LastName = request.getParameter("lastname");
		String Year = request.getParameter("year");
		// we have to get image in image part
		Part imagePart = request.getPart("image");
		// now we have to convert image into input stream
		InputStream image = imagePart.getInputStream();

		Candidate candidate = new Candidate();// adding details in candidate object
		candidate.setFirstName(FirstName);
		candidate.setLastName(LastName);
		candidate.setYear(Year);
		candidate.setImage(image);
		
		
		System.out.println(FirstName);
		try {
			AdminDao adminDao = new AdminDaoImpl();
			int result = adminDao.addcandidate(candidate); // adding candidate object in add candidate method of//
															// admindaoimpl coz that method is dealing with database

			if (result > 0) {
				response.sendRedirect("candidate_list.jsp?Message= Candidate Added Succesfully");
			} else {
				response.sendRedirect("add_candidate.jsp?Message= Candidate Can't Be Added");

			}
		} catch (ClassNotFoundException | SQLException e) {
			response.sendRedirect("add_candidate.jsp?Message= Candidate Can't Be Added");

			e.printStackTrace();
		}

	}

}
