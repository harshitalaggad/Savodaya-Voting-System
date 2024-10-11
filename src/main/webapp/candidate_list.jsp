<% response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); %>
<% response.setHeader("Pragma", "no-cache"); %>
<%@page import="java.util.ResourceBundle.Control"%>
<%@page import="org.apache.catalina.webresources.Cache"%>
<%@page import="org.eclipse.jdt.internal.compiler.ast.IfStatement"%>
<%@page import="com.utils.utils"%>
<%@page import="org.apache.tomcat.util.http.fileupload.util.mime.MimeUtility"%>
<%@page import="java.util.*"%>
<%@page import="com.pojo.Candidate"%>
<%@page import="com.Dao.AdminDaoImpl"%>
<%@page import="com.Dao.AdminDao"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<!doctype html>
<html>
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <script src="https://cdn.tailwindcss.com"></script>
</head>
<style>
  *{
    margin: 0;
    padding: 0;
  }
  .bg-img{	
    background-image: url('images/edwin-andrade-4V1dC_eoCwg-unsplash.png');
    background-size: cover ;
    background-repeat: no-repeat;
    height: 100vh;
	background-position: center;
	position: relative;
  
}
@import url("https://fonts.googleapis.com/css?family=Montserrat&display=swap");

* {
  padding: 0;
  margin: 0;
}
.animation{
  

  height: 100vh;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
font-size: 500%;
font-style: initial;
font-stretch: narrower;
font-weight: bold;
color: rgb(248, 245, 241);
}

h1 {
  font-family ui-sans-serif, system-ui, sans-serif, "Apple Color Emoji", "Segoe UI Emoji", "Segoe UI Symbol", "Noto Color Emoji";
  max-width: 40ch;
  text-align: center;
  transform: scale(0.94);
  animation: scale 3s forwards cubic-bezier(0.5, 1, 0.89, 1);
  
}

  .table{
    font-family:  ui-sans-serif, system-ui, sans-serif, "Apple Color Emoji", "Segoe UI Emoji", "Segoe UI Symbol", "Noto Color Emoji";
    width: 80%;
    margin: auto;
    margin-top: 50px;
    background-color: rgb(202, 207, 212);
    border-collapse: collapse;
   
  }
.button {
	font-size: 16px;
	font-weight: 700;
	padding: 12px 20px;
	text-transform: uppercase;
	font-family:  ui-sans-serif, system-ui, sans-serif, "Apple Color Emoji", "Segoe UI Emoji", "Segoe UI Symbol", "Noto Color Emoji";
	border-radius: 30px;
	border: 1px solid #5e97d1;
    background-color: rgb(202, 207, 212);
	color: rgb(202, 207, 212);
	cursor: pointer;
}
  
 .para6{
    margin-left: 1020px;
    
  }

  img {
    width: 80px;
    height: 60px;
  }
.addcandidate:hover {
	transition: .2s ease-in-out;
	transform: scale(1.1);
}
.heading4 {
    font-family: ui-sans-serif, system-ui, sans-serif, "Apple Color Emoji", "Segoe UI Emoji", "Segoe UI Symbol", "Noto Color Emoji";
	font-size: 40px;
	margin-top: 17px;
	margin-left: 550px;
	color: #FFFF;
	   
}

  td,th{
    
  border: 0.8px solid #111111;
  text-align: left;
  padding: 2px;
  }
</style>
<body class="bg-img">
  <header class="text-white bg-dar">
    
    <div class="container mx-auto flex flex-wrap p-5 flex-col md:flex-row items-center">
      
      <a font size='xxlarge',class="flex title-font font-medium items-center text-gray-900 mb-4 md:mb-0">
       <div>
        <span class="ml-3 text-xl" >Savodaya e-vote</span>
        </div>
      </a>
      <nav class="md:ml-auto flex flex-wrap items-center text-base justify-center">
                    <a href="welcome_voter.html"class="mr-5 hover:text-gray-900">Home</a>
      
        <a href="about.jsp"class="mr-5 hover:text-gray-900">About</a>
        <a href="add_candidate.jsp"class="mr-5 hover:text-gray-900">Add Candidate</a>
        <a href="adminlogout"class="mr-5 hover:text-gray-900">LogOut</a>
      </nav>
      
        <svg fill="none" stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2" class="w-4 h-4 ml-1" viewBox="0 0 24 24">
          <path d="M5 12h14M12 5l7 7-7 7"></path>
        </svg>
      
      
    
    
  </header>
  

	<h3 class="heading4">CANDIDATE LIST</h3>
	<%
	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
	response.setHeader("Pragma", "no-cache");
	String username = (String) session.getAttribute("AdminId");
	String password = (String) session.getAttribute("AdminPassword");
	//out.print(username);
	if (username == null & password == null)
		response.sendRedirect("admin_login.jsp");
	%>


	<%
	String Message = request.getParameter("Message");
	if (Message != null) {
		out.print("<p>" + Message + "<p>");
	}
	%>
	<%
    //Candidate can = new Candidate();

	AdminDao adminDao = new AdminDaoImpl();
	List<Candidate> candidateList = adminDao.candidatelist();
    

	%>
	
	

	<table class="table">


		<tr>
			<th>S.No</th>
			<th>First Name</th>
			<th>Last name</th>
			<th>Year</th>
			<th>Image</th>
			<th>Votes</th>
			<th>action</th>
		</tr>
		<%
		for (Candidate candidate : candidateList) {
			//for (Candidate can : candidateList){//int totalVotes = adminDao.selectcandidatevotes(can.getSNo());
			       int candidateSNo = candidate.getSNo();

			    int candidateVotes = adminDao.selectcandidatevotes(candidateSNo);

		%>
		<tr>

			<td><%=candidate.getSNo()%></td>
			<td><%=candidate.getFirstName()%></td>
			<td><%=candidate.getLastName()%></td>
			<td><%=candidate.getYear()%></td>
			<td><img src="data:image/jsp;base64,<%=utils.displayImage(candidate.getImage())%>" /></td>
			<td><%=candidateVotes%></td>
			
			<td><a href="edit_candidate.jsp?candidateSno=<%=candidate.getSNo()%>">
					<input type="button" value="EDIT" />
			</a></td>
		</tr>
		<%
		}
		%>
	</table>

<
  </body>
</html>