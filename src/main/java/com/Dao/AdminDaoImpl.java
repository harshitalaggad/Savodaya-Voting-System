package com.Dao;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.jdbc.Blob;
import com.pojo.Candidate;

public class AdminDaoImpl implements AdminDao {
	// database code
	public final String DRIVER = "com.mysql.cj.jdbc.Driver";
	public final String URL = "jdbc:mysql://localhost:3306/candidateregistration";
	public final String UN = "root";
	public final String PASSWORD = "12345";

	// queries
	private final String INSERT_CANDIDATE = "INSERT INTO `candidateregistration`.`candidatedetails` (`FirstName`, `LastName`, `Year` ,`Image`) VALUES (?,?,?,?)\r\n";
	private final String GET_CANDIDATE_BY_SNO = "SELECT * FROM `candidateregistration`.`candidatedetails` WHERE (`SNo` = ?)\r\n";

	private final String UPDATE_CANDIDATE = "UPDATE candidatedetails SET FirstName = ?, LastName = ?, Year = ?, Image = ? WHERE SNo = ?";
	private final String DELETE_CANDIDATE = "DELETE FROM `candidateregistration`.`candidatedetails` WHERE (`SNo` = ?)\r\n";
	private final String GET_CANDIDATE_LIST = "SELECT * FROM candidateregistration.candidatedetails";
	final String CHECK_ADIMN = "SELECT * FROM voterregistration.admindetails WHERE AdminId = ? AND AdminPassword = ?";

	private Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName(DRIVER);
		Connection connection = DriverManager.getConnection(URL, UN, PASSWORD);
		return connection;
	}

	@Override
	public int addcandidate(Candidate candidate) throws ClassNotFoundException, SQLException {
		int result = 0;
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CANDIDATE);) {
			preparedStatement.setString(1, candidate.getFirstName());
			preparedStatement.setString(2, candidate.getLastName());
			preparedStatement.setString(3, candidate.getYear());
			// have to get image in blob
			preparedStatement.setBlob(4, candidate.getImage());

			result = preparedStatement.executeUpdate();
		}
		return result;
	}

	@Override
	public Candidate getcandidatebySno(int Sno) throws ClassNotFoundException, SQLException {
		Candidate candidate = null;
		ResultSet resultSet = null;
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(GET_CANDIDATE_BY_SNO);) {
			preparedStatement.setInt(1, Sno);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				int sno = resultSet.getInt("SNo");
				String firstname = resultSet.getString("FirstName");
				String lastname = resultSet.getString("LastName");
				String year = resultSet.getString("Year");
				Blob blob = (Blob) resultSet.getBlob("Image");
				InputStream image = blob.getBinaryStream();

				candidate = new Candidate(sno, firstname, lastname, year, image);
			}
		} finally {
			if (resultSet != null)
				resultSet.close();
		}

		return candidate;

	}

//"UPDATE `candidateregistration`.`candidatedetails` SET `FirstName` = ?, `LastName` = ?, `Year` = ?, `Image` = ?, WHERE (`SNo` = ?)\r\n";
	@Override
	public int updatecandidate(Candidate candidate) throws ClassNotFoundException, SQLException {
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_CANDIDATE)) {
			int result = 0;
			preparedStatement.setString(1, candidate.getFirstName());
			preparedStatement.setString(2, candidate.getLastName());
			preparedStatement.setString(3, candidate.getYear());
			// have to get image in blob
			preparedStatement.setBlob(4, candidate.getImage());
			preparedStatement.setInt(5, candidate.getSNo());

			result = preparedStatement.executeUpdate();
			return result;
		}
	}

	@Override
	public int deletecandidate(int SNo) throws ClassNotFoundException, SQLException {
		int result = 0;

		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(DELETE_CANDIDATE)) {

			preparedStatement.setInt(1, SNo);

			result= preparedStatement.executeUpdate();
			
			return result;
		}
	}

	@Override
	public List<Candidate> candidatelist() throws ClassNotFoundException, SQLException {

		List<Candidate> candidateList = new ArrayList<Candidate>();
		Candidate candidate = null;
		try (Connection connection = getConnection();
				Statement statement = connection.createStatement();
				ResultSet rSet = statement.executeQuery(GET_CANDIDATE_LIST);) {
			while (rSet.next()) {
				int sno = rSet.getInt("SNo");
				String firstname = rSet.getString("FirstName");
				String lastname = rSet.getString("LastName");
				String year = rSet.getString("Year");
				Blob blob = (Blob) rSet.getBlob("Image");
				InputStream image = blob.getBinaryStream();

				candidate = new Candidate(sno, firstname, lastname, year, image);
				candidateList.add(candidate);
			}
			return candidateList;
		}
	}

	@Override
	public boolean authenticate(String userName, String password) throws SQLException, ClassNotFoundException {
		boolean result = false;

		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(CHECK_ADIMN);) {

			preparedStatement.setString(1, userName);
			preparedStatement.setString(2, password);

			ResultSet resultSet = preparedStatement.executeQuery();
			result = resultSet.next();
		}
		return result;

	}

	@Override
	public int selectcandidatevotes(int SNo) throws ClassNotFoundException, SQLException {
		int totalVotes = 0;

	        // Establish a database connection (ensure that you have the correct connection details)
	        try (Connection connection = getConnection()) {
	            // Create a PreparedStatement with the SQL query
	            String sqlQuery = "SELECT TotalVotes FROM candidatedetails WHERE SNo = ?";
	            try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)) {
	                // Set the parameter in the PreparedStatement
	                preparedStatement.setInt(1, SNo);

	                // Execute the query and retrieve the result set
	                try (ResultSet resultSet = preparedStatement.executeQuery()) {
	                    // Check if there is a result and retrieve the total votes
	                    if (resultSet.next()) {
	                        totalVotes = resultSet.getInt("TotalVotes");
	                    }
	                }
	            }
	        }

	        return totalVotes;
	    

		
	}

}
