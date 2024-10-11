package com.Dao;

import java.sql.SQLException;

import com.pojo.Voter;

//funtionality of voter
//login, logout,register,vote????
public interface VoterDao {
	int addvoter(Voter voter) throws ClassNotFoundException, SQLException;

	
	boolean authenticateVoter(int rollNo, String voterPwd) throws ClassNotFoundException, SQLException;// login

	int updatevoterstatus(int RollNo) throws ClassNotFoundException, SQLException;
	int selectcandidatevotes(int SNo)throws ClassNotFoundException,SQLException;
	int updatecandidatevotes(int SNo) throws ClassNotFoundException, SQLException;
	int getvoterstatus(int RollNo)throws ClassNotFoundException,SQLException;

}
