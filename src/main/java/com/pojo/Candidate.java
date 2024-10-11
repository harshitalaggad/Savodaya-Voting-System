package com.pojo;

//here we will store the entities of candidate
import java.io.InputStream;

public class Candidate {
	private int SNo;
	private String FirstName;
	private String LastName;
	private String Year;
	private InputStream Image;
	private int TotalVotes;

	public Candidate() {
		super();
	}

	public Candidate(int sNo, String firstName, String lastName, String year, InputStream image) {
		super();
		SNo = sNo;
		FirstName = firstName;
		LastName = lastName;
		Year = year;
		Image = image;

	}

	public Candidate(int sNo, String firstName, String lastName, String year, InputStream image, int totalVotes) {
		super();
		SNo = sNo;
		FirstName = firstName;
		LastName = lastName;
		Year = year;
		Image = image;
		TotalVotes = totalVotes;
	}

	public int getSNo() {
		return SNo;
	}

	public void setSNo(int sNo) {
		SNo = sNo;
	}

	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String firstName) {
		FirstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public String getYear() {
		return Year;
	}

	public void setYear(String year) {
		Year = year;
	}

	public InputStream getImage() {
		return Image;
	}

	public void setImage(InputStream image) {
		Image = image;
	}

	public int getTotalVotes() {
	    System.out.println("Total Votes: " + this.TotalVotes);

		return TotalVotes;
	}

	public void setTotalVotes(int totalVotes) {
		TotalVotes = totalVotes;
	
	}

	@Override
	public String toString() {
		return "Candidate [SNo=" + SNo + ", FirstName=" + FirstName + ", LastName=" + LastName + ", Year=" + Year + "]";
	}
	
}
