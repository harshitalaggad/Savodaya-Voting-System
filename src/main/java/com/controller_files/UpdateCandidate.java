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
@WebServlet("/updatecandidate")
public class UpdateCandidate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String sno = request.getParameter("SNo");
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
		candidate.setSNo(Integer.parseInt(sno));

		System.out.println(FirstName);
		try {
			AdminDao adminDao = new AdminDaoImpl();
			int result = adminDao.updatecandidate(candidate); // adding candidate object in add candidate method of//
															// admindaoimpl coz that method is dealing with database
			System.out.println("result : " + result);
			if (result > 0) {
				System.out.println("1");
				response.sendRedirect("candidate_list.jsp?Message= Candidate Updated Succesfully");
			} else {
				System.out.println("2");
				response.sendRedirect("edit_candidate.jsp?Message=Candidate Can't Be Updated&candidateSno="+sno);

			}
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("3");
			response.sendRedirect("edit_candidate.jsp?Message=Candidate Can't Be Updated&candidateSno="+sno);


			e.printStackTrace();
		}

	}

}
