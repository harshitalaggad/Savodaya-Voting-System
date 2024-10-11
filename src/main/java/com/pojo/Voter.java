package com.pojo;

import java.time.LocalDate;

//here we will store the entities of voter
public class Voter {
	private String firstName;
	private String LastName;
	private String Gender;
	private LocalDate Dob;
	private String Branch;
	private String Year;
	private int RollNo;
	private String VoterPassword;
	private boolean VotingStatus;

	public boolean isVotingStatus() {
		return VotingStatus;
	}

	public void setVotingStatus(boolean votingStatus) {
		VotingStatus = votingStatus;
	}

	public Voter() {
		super();
	}

	public Voter(String firstName, String lastName, String gender, LocalDate dob, String branch, String year, int rollNo,
			String voterPassword) {
		super();
		this.firstName = firstName;
		LastName = lastName;
		Gender = gender;
		Dob = dob;
		Branch = branch;
		Year = year;
		RollNo = rollNo;
		VoterPassword = voterPassword;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public String getGender() {
		return Gender;
	}

	public void setGender(String gender) {
		Gender = gender;
	}

	public LocalDate getDob() {
		return Dob;
	}

	public void setDob(LocalDate dob) {
		Dob = dob;
	}

	public String getBranch() {
		return Branch;
	}

	public void setBranch(String branch) {
		Branch = branch;
	}

	public String getYear() {
		return Year;
	}

	public void setYear(String year) {
		Year = year;
	}

	public int getRollNo() {
		return RollNo;
	}

	public void setRollNo(int rollNo) {
		RollNo = rollNo;
	}

	public String getVoterPassword() {
		return VoterPassword;
	}

	public void setVoterPassword(String voterPassword) {
		VoterPassword = voterPassword;
	}

	@Override
	public String toString() {
		return "Voter [firstName=" + firstName + ", LastName=" + LastName + ", Gender=" + Gender + ", Dob=" + Dob
				+ ", Branch=" + Branch + ", Year=" + Year + ", RollNo=" + RollNo + ", VoterPassword=" + VoterPassword
				+ "]";
	}

}
