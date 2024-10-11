<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%><!doctype html>
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
  font-family: 'sans-serif';
  max-width: 40ch;
  text-align: center;
  transform: scale(0.94);
  animation: scale 3s forwards cubic-bezier(0.5, 1, 0.89, 1);
  
}
@keyframes scale {
  100% {
    transform: scale(1);
  }
}

span {
  display: inline-block;
  opacity: 0;
  filter: blur(4px);
  
}

span:nth-child(1) {
  animation: fade-in 0.8s 0.1s forwards cubic-bezier(0.11, 0, 0.5, 0);
}

span:nth-child(2) {
  animation: fade-in 0.8s 0.2s forwards cubic-bezier(0.11, 0, 0.5, 0);
}

span:nth-child(3) {
  animation: fade-in 0.8s 0.3s forwards cubic-bezier(0.11, 0, 0.5, 0);
}

span:nth-child(4) {
  animation: fade-in 0.8s 0.4s forwards cubic-bezier(0.11, 0, 0.5, 0);
}

span:nth-child(5) {
  animation: fade-in 0.8s 0.5s forwards cubic-bezier(0.11, 0, 0.5, 0);
}

span:nth-child(6) {
  animation: fade-in 0.8s 0.6s forwards cubic-bezier(0.11, 0, 0.5, 0);
}

span:nth-child(7) {
  animation: fade-in 0.8s 0.7s forwards cubic-bezier(0.11, 0, 0.5, 0);
}

span:nth-child(8) {
  animation: fade-in 0.8s 0.8s forwards cubic-bezier(0.11, 0, 0.5, 0);
}

span:nth-child(9) {
  animation: fade-in 0.8s 0.9s forwards cubic-bezier(0.11, 0, 0.5, 0);
}

span:nth-child(10) {
  animation: fade-in 0.8s 1s forwards cubic-bezier(0.11, 0, 0.5, 0);
}

span:nth-child(11) {
  animation: fade-in 0.8s 1.1s forwards cubic-bezier(0.11, 0, 0.5, 0);
}

span:nth-child(12) {
  animation: fade-in 0.8s 1.2s forwards cubic-bezier(0.11, 0, 0.5, 0);
}

span:nth-child(13) {
  animation: fade-in 0.8s 1.3s forwards cubic-bezier(0.11, 0, 0.5, 0);
}

span:nth-child(14) {
  animation: fade-in 0.8s 1.4s forwards cubic-bezier(0.11, 0, 0.5, 0);
}

span:nth-child(15) {
  animation: fade-in 0.8s 1.5s forwards cubic-bezier(0.11, 0, 0.5, 0);
}

span:nth-child(16) {
  animation: fade-in 0.8s 1.6s forwards cubic-bezier(0.11, 0, 0.5, 0);
}

span:nth-child(17) {
  animation: fade-in 0.8s 1.7s forwards cubic-bezier(0.11, 0, 0.5, 0);
}

span:nth-child(18) {
  animation: fade-in 0.8s 1.8s forwards cubic-bezier(0.11, 0, 0.5, 0);
}

@keyframes fade-in {
  100% {
    opacity: 1;
    filter: blur(0);
  }
}
.extra1{

font-size: 30%;
font-style: initial;
font-stretch: narrower;
  font-family: 'sans-serif';
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
        <a href="candidate_list.jsp"class="mr-5 hover:text-gray-900">Candidate List</a>
        <a href="adminlogout"class="mr-5 hover:text-gray-900">LogOut</a>
      </nav>
      
        <svg fill="none" stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2" class="w-4 h-4 ml-1" viewBox="0 0 24 24">
          <path d="M5 12h14M12 5l7 7-7 7"></path>
        </svg>
      
      
    
    
  </header>
  <div class="animation">
  <h1 >
    <span>WELCOME</span>
    <span>ADMIN</span>
    
  </h1>
    <p class="extra1">here you can view candidate list and their votes,add candidates and remove them if necessary!!!</p>
  
  </div>
	<%
	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
	response.setHeader("Pragma", "no-cache");
	String username = (String) session.getAttribute("AdminId");
	String password = (String) session.getAttribute("AdminPassword");
	//out.print(username);
	if (username == null & password == null)
		response.sendRedirect("admin_login.jsp");
	%>
  </body>
</html>