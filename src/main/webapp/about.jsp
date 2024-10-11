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
.container{

  color: aliceblue;
  float:right;
  font-size:  large;
  margin-top: 10px;
  margin-bottom: 160px;
}
.about{
  color: black;
  font-size: xx-large;
  
}
.img{
position: absolute;
width: 450px;
margin-top: 220px;
margin-left: 1000px;
 
  
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
        <a href="voter_login.jsp"class="mr-5 hover:text-gray-900">Voter Login</a>
        <a href="admin_login.jsp"class="mr-5 hover:text-gray-900">Admin Login</a>
        <a href="adminlogout"class="mr-5 hover:text-gray-900">LogOut</a>
      </nav>
      
        <svg fill="none" stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2" class="w-4 h-4 ml-1" viewBox="0 0 24 24">
          <path d="M5 12h14M12 5l7 7-7 7"></path>
        </svg>
      
      
    
    
  </header>

<container class="container">
  <div class="about"><u>ABOUT</u></div>
  <div>

    Welcome to our college's dedicated voting platform, where voices are heard and choices matter.<br>
     At the heart of our digital democracy, students can actively participate in shaping the future<br>
      of our vibrant community. Whether it's electing student representatives, deciding on campus<br>
       initiatives, or voicing opinions on crucial matters, this platform empowers every member to <br>
       engage in the democratic process effortlessly. Our user-friendly interface ensures a seamless.<br>
        voting experience, making it convenient for students to cast their votes with just a few clicks<br>
       Behind the scenes, our vigilant administrative team oversees the entire process, ensuring transparency<br>
         and integrity in the electoral system. Real-time updates and comprehensive analytics enable administrators<br>
          to gain valuable insights into voting trends and student preferences. Join us in fostering a culture of<br>
                  inclusivity, participation, and shared decision-making as we navigate the journey of our college's progress<br>
   together. Your vote, your voice – let's shape the future collaboratively</div>
  </container>
  <img class="img"
  src="images/Screenshot 2024-01-08 021817.png" >
  </body>
</html>