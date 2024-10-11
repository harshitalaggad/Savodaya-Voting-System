package com.Dao;

//import java.io.InputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

// com.mysql.cj.jdbc.Blob;
//import com.pojo.Candidate;
import com.pojo.Voter;

//functionalities of voter
public class VoterDaoImpl implements VoterDao {
	// database code
	public final String DRIVER = "com.mysql.cj.jdbc.Driver";
	public final String URL = "jdbc:mysql://localhost:3306/voterregistration";
	public final String UN = "root";
	public final String PASSWORD = "12345";

	// queries
	private final String INSERT_VOTER = "INSERT INTO `voterregistration`.`voterdetails` (`FirstName`, `LastName`, `Gender`, `Dob`, `Branch`, `Year`, `RollNo.`, `PassWord`) VALUES (?,?,?,?,?,?,?,?)\r\n";
	private final String UPDATE_VOTER_STATUS = "UPDATE `voterregistration`.`voterdetails` SET `VoterStatus` = 1 WHERE `RollNo.` = ?";
	private final String AUTHENTICATE_VOTER = "SELECT * FROM `voterregistration`.`voterdetails` WHERE `RollNo.` = ? AND PassWord = ?\r\n";
	private final String SELECT_CANDIDATE_VOTES = "SELECT TotalVotes FROM `candidateregistration`.`candidatedetails` WHERE `SNo` = ?";
	private final String SELECT_VOTER_STATUS = "SELECT VoterStatus FROM `voterregistration`.`voterdetails` WHERE (`RollNo.` = ?)";
	private final String UPDATE_CANDIDATE_VOTES = "UPDATE `candidateregistration`.`candidatedetails` SET `TotalVotes` = ? WHERE `SNo` = ?";
	private final String query = "SELECT RollNo FROM `voterregistration`.`voterdetails`"; // Change your_table_name to your actual table name

	// getconnection method

	private Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName(DRIVER);
		Connection connection = DriverManager.getConnection(URL, UN, PASSWORD);
		return connection;
	}

	@Override
	public int addvoter(Voter voter) throws ClassNotFoundException, SQLException {
		int result = 0;
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_VOTER)) {
			preparedStatement.setString(1, voter.getFirstName());
			preparedStatement.setString(2, voter.getLastName());
			preparedStatement.setString(3, voter.getGender());
			preparedStatement.setDate(4, Date.valueOf(voter.getDob()));
			preparedStatement.setString(5, voter.getBranch());
			preparedStatement.setString(6, voter.getYear());
			preparedStatement.setInt(7, voter.getRollNo());
			preparedStatement.setString(8, voter.getVoterPassword());

			result = preparedStatement.executeUpdate();
			//System.out.println(result);
		}
		return result;

	}

	/*
	 * @Override public boolean updatevoterbyRollno(int RollNo) throws
	 * ClassNotFoundException, SQLException { Boolean voter = null; ResultSet
	 * resultSet = null; try (Connection connection = getConnection();
	 * PreparedStatement preparedStatement =
	 * connection.prepareStatement(UPDATE_VOTER_BY_ID);) {
	 * preparedStatement.setInt(1, RollNo); preparedStatement.setInt(1, RollNo);
	 * resultSet = preparedStatement.executeQuery(); if (resultSet.next()) { int
	 * rollno = resultSet.getInt("RollNo");
	 * 
	 * } } finally { if (resultSet != null) resultSet.close(); }
	 * 
	 * return voter;
	 * 
	 * }
	 */
	@Override
	public boolean authenticateVoter(int rollNo, String voterPwd) throws SQLException, ClassNotFoundException {

		boolean result = false;

		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(AUTHENTICATE_VOTER);) {
			preparedStatement.setInt(1, rollNo);
			preparedStatement.setString(2, voterPwd);

			ResultSet resultSet = preparedStatement.executeQuery();
			result = resultSet.next();
			if (resultSet.next()) {
				rollNo = resultSet.getInt("RollNo.");
				//System.out.println(rollNo);
			}

		}
		return result;

	}

	@Override
	public int updatevoterstatus(int RollNo) throws ClassNotFoundException, SQLException {
		int status = 0;
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_VOTER_STATUS);) {
			preparedStatement.setInt(1, RollNo);
			status = preparedStatement.executeUpdate();
		}
		return status;
	}

	@Override
	public int selectcandidatevotes(int SNo) throws ClassNotFoundException, SQLException {

		int currentvotes = 0;
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CANDIDATE_VOTES);) {
			preparedStatement.setInt(1, SNo);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				currentvotes = resultSet.getInt("TotalVotes");
			}
			//System.out.println(currentvotes);
			return currentvotes;
		}
	}

	@Override
	public int updatecandidatevotes(int SNo) throws ClassNotFoundException, SQLException {
		int votes = 0;
		int currentvotes = selectcandidatevotes(SNo);
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_CANDIDATE_VOTES);) {

			currentvotes++;
			System.out.println(currentvotes);
			preparedStatement.setInt(1, currentvotes);
			preparedStatement.setInt(2, SNo);
			int vote = preparedStatement.executeUpdate();
			System.out.println("votes"+vote);
			votes = vote;
			

			return votes;
		
		}
	}

	@Override
	public int getvoterstatus(int RollNo) throws ClassNotFoundException, SQLException {
		int status = 0;
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_VOTER_STATUS);) {
			preparedStatement.setInt(1, RollNo);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				status = resultSet.getInt("VoterStatus");
				//System.out.println("status"+status);
				
			}
			//System.out.println("hi");
			return status;

		}
	}
	 public List<String> getColumnData(String RollNo) throws ClassNotFoundException , SQLException{
	        List<String> columnData = new ArrayList<>();

	        try (Connection connection =getConnection()) {

	            try (PreparedStatement preparedStatement = connection.prepareStatement(query);
	                 ResultSet resultSet = preparedStatement.executeQuery()) {

	                while (resultSet.next()) {
	                    String value = resultSet.getString(RollNo);
	                    columnData.add(value);
	                }
	            }
	        } 

	        return columnData;
	    }
	
	
}
