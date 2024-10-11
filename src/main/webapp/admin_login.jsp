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



/*/////////////// FORM STYLES ////////////////////*/

form .field-group {
    background: rgba(16, 16, 16, 0.15);
    display: flex;
    display: flex;
    display: -webkit-box;
    /* OLD - iOS 6-, Safari 3.1-6 */
    display: -moz-box;
    /* OLD - Firefox 19- (buggy but mostly works) */
    display: -ms-flexbox;
    /* TWEENER - IE 10 */
    display: -webkit-flex;
    /* NEW - Chrome */
    margin-bottom: 20px;
    padding: 2px 10px 2px 0;
	border-radius: 35px;
	-webkit-border-radius: 35px;
	-moz-border-radius: 35px;
	-ms-border-radius: 35px;
	-o-border-radius: 35px;
}

form .field-group span {
    flex: 1;
    -webkit-box-flex: 1;      /* OLD - iOS 6-, Safari 3.1-6 */
    -moz-box-flex: 1;         /* OLD - Firefox 19- */
    width: 20%;               /* For old syntax, otherwise collapses. */
    -webkit-flex: 1;          /* Chrome */
    -ms-flex: 1;              /* IE 10 */
    color: #fff;
    background: transparent;
    line-height: 49px;
    text-align: right;
}


form .field-group .wthree-field {
    flex: 4 50%;
    -webkit-box-flex:4 50%;     /* OLD - iOS 6-, Safari 3.1-6 */
    -moz-box-flex: 4 50%;        /* OLD - Firefox 19- */
    -webkit-flex: 4 50%;          /* Chrome */
    -ms-flex: 4 50%;             /* IE 10 */
}

.wthree-field button.btn {
    background: #fc636b;
    border: none;
    color: #fff;
    padding: 11px 15px;
    text-transform: uppercase;
	font-family: 'Mukta', sans-serif;
    font-size: 16px;
	width:100%;
	margin-top:10px;
    letter-spacing: 2px;
    cursor: pointer;
    transition: 0.5s all;
    -webkit-transition: 0.5s all;
    -moz-transition: 0.5s all;
    -o-transition: 0.5s all;
    -ms-transition: 0.5s all;
	border-radius: 35px;
	-webkit-border-radius: 35px;
	-moz-border-radius: 35px;
	-ms-border-radius: 35px;
	-o-border-radius: 35px;
}

.bottom-grid,.bottom-grid1{
    display: flex;
    display: -webkit-box;
    display: -moz-box;
    display: -ms-flexbox;
    display: -webkit-flex;
    justify-content: space-between;
    margin: 0em 10em;
}
.wthree-field input {
    padding: 10px 0 10px 15px;
    font-size: 17px;
    font-weight: 300;
	color:#ddd;
    letter-spacing: 1px;
    border: none;
    background: transparent;
    box-sizing: border-box;
	font-family: 'Mukta', sans-serif;
    width: 100%;
    outline: none;
}
::-webkit-input-placeholder { /* Chrome/Opera/Safari */
  color: #ccc;
}
::-moz-placeholder { /* Firefox 19+ */
  color: #ccc;
}
::-ms-input-placeholder { /* IE 10+ */
  color: #ccc;
}
::-moz-placeholder { /* Firefox 18- */
  color: #ccc;
}

/* -- //Responsive code -- */
/*!
 *  Font Awesome 4.7.0 by @davegandy - http://fontawesome.io - @fontawesome
 *  License - http://fontawesome.io/license (Font: SIL OFL 1.1, CSS: MIT License)
 */
 @font-face {
    font-family: 'FontAwesome';
    src: url('../fonts/fontawesome-webfont.eot?v=4.7.0');
    src: url('../fonts/fontawesome-webfont.eot?#iefix&v=4.7.0') format('embedded-opentype'),url('../fonts/fontawesome-webfont.woff2?v=4.7.0') format('woff2'),url('../fonts/fontawesome-webfont.woff?v=4.7.0') format('woff'),url('../fonts/fontawesome-webfont.ttf?v=4.7.0') format('truetype'),url('../fonts/fontawesome-webfont.svg?v=4.7.0#fontawesomeregular') format('svg');
    font-weight: normal;
    font-style: normal
}

.fa {
    display: inline-block;
    font: normal normal normal 14px/1 FontAwesome;
    font-size: inherit;
    text-rendering: auto;
    -webkit-font-smoothing: antialiased;
    -moz-osx-font-smoothing: grayscale
}

.fa-user:before {
    content: "\f007"
}


.fa-lock:before {
    content: "\f023"
}

.extra{
  width:  35%;
  margin: auto;
  margin-top: 13%;
  
  
}
</style>
<head>

	<%
	String Message = request.getParameter("Message");
	if (Message != null) {
		out.print("<p>" + Message + "<p>");
	}
	%>

</head>

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
      
        <a href=""class="mr-5 hover:text-gray-900">About</a>
        <a href="voter_login.jsp"class="mr-5 hover:text-gray-900">Voter Login</a>
        <a href="admin_login.jsp"class="mr-5 hover:text-gray-900">Admin Login</a>
        <a href="voter_registration.jsp"class="mr-5 hover:text-gray-900">Register</a>
      </nav>
      
        <svg fill="none" stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2" class="w-4 h-4 ml-1" viewBox="0 0 24 24">
          <path d="M5 12h14M12 5l7 7-7 7"></path>
        </svg>
      
      
    
    
  </header>
  <div class="extra">
  <div class="content-bottom">
    <form action="adminlogin" method="post">
      <div class="field-group">
        <span class="fa fa-user" aria-hidden="true"></span>
        <div class="wthree-field">
          <input name="AdminId" id="AdminId" type="text" value="" placeholder="AdminId" required>
        </div>
      </div>
      <br>
      <div class="field-group">
        <span class="fa fa-lock" aria-hidden="true"></span>
        <div class="wthree-field">
          <input name="AdminPassword" id="AdminPassword" type="Password" placeholder="AdminPassword">
        </div>
      </div>
      <br>
      <div class="wthree-field">
        <button type="submit" class="btn">submit</button>
      </div>
    </form>
  </div>
  </div>
  </body>
</html>