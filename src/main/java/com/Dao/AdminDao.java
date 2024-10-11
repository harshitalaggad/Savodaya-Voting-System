package com.Dao;
//here we store the functionalities of admin

import java.sql.SQLException;
import java.util.List;

import com.pojo.Candidate;

public interface AdminDao {
	int addcandidate(Candidate candidate) throws ClassNotFoundException, SQLException;
	
	Candidate getcandidatebySno(int Sno) throws ClassNotFoundException, SQLException;

	int updatecandidate(Candidate candidate) throws ClassNotFoundException, SQLException;

	int deletecandidate(int SNo) throws ClassNotFoundException, SQLException;

	List<Candidate> candidatelist() throws ClassNotFoundException, SQLException;// admin candidate ki list vote.jsp pr
																				// dikha raha h
	boolean authenticate(String userName, String password) throws SQLException,ClassNotFoundException;

   int selectcandidatevotes(int SNo) throws ClassNotFoundException, SQLException;
	
}
