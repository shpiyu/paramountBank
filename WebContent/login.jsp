<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title></title>

	<style type="text/css">
		@media (max-width: 1440px)
.bg-image {
    width: 480px;
}
		.bg-image {
    bottom: 0;
    position: absolute;
    overflow: hidden;
    right: 0;
    text-align: right;
    top: 80px;
    width: 500px;
    z-index: 0;
}
.bg-image img {
    margin-right: -90px;
    max-width: 100%;
    z-index: 0;
}
.bg-image .mobile {
    display: none;
}
body {
    color: #757575;
    font-family: 'Circular-Book',Arial,sans-serif;
    line-height: 1.278;
    margin: 0;
    min-height: 100%;
    padding: 0;
    display: -webkit-box;
    display: -ms-flexbox;
    display: -webkit-flex;
    display: flex;
    -webkit-box-orient: vertical;
    -webkit-flex-direction: column;
    -ms-flex-direction: column;
    flex-direction: column;
    -webkit-transition: none;
    -webkit-font-smoothing: antialiased;
    -moz-osx-font-smoothing: grayscale;
}
#menu {
    position: absolute;
    right: 36px;
    top: 27px;
    z-index: 999;
    line-height: 26px;
}
#menu ul {
    list-style: none;
    margin: 0;
    padding: 0;
}
#menu li {
    display: inline-block;
    padding-left: 20px;
}
#menu a {
    color: #757575;
    text-decoration: none;
}

#menu a:hover{
    text-decoration: underline;
}

html {
    -webkit-box-sizing: border-box;
    -moz-box-sizing: border-box;
    -ms-box-sizing: border-box;
    -o-box-sizing: border-box;
    box-sizing: border-box;
    font-size: 18px;
    height: 100%;
    overflow-y: -moz-scrollbars-vertical;
    overflow-y: scroll;
}

#logo {
       height: 24px;
    left: 36px;
    position: absolute;
    top: 27px;
    width: 200px;
    z-index: 999;
    line-height: 26px;
    display: inline-block;
    padding-left: 20px;
    color: #e50000;
    font-style: bold;
}

.text-container {
    max-width: 600px;
    padding-right: 50px;
}
.wrapper {
    box-sizing: border-box;
    padding-bottom: 200px;
    padding-left: 185px;
    padding-top: 225px;
    position: relative;
}
p {
    display: block;
    -webkit-margin-before: 1em;
    -webkit-margin-after: 1em;
    -webkit-margin-start: 0px;
    -webkit-margin-end: 0px;
}
div {
    display: block;
}
.forward-link {
    color: #ed1c24;
    text-decoration: none;
}

/* form styles */
input, textarea {
  font    : .9em/1.5em "handwriting", sans-serif;

  border: none;
  padding : 10px;
  margin  : 0;
  width   : 240px;
  margin-bottom : 2px; 
  border-bottom: 1px solid #757575;
  background: none;
}


.mybutton, .mybutton:visited{
    

    border: 1px solid #333;
    padding-top: 6px;
    padding-bottom: 6px;
    padding-left: 8px;
    padding-right: 8px;
    color: #333;
    margin-top: 15px;
    margin-bottom: 8px; 
    font-size: 1.2em;
    background-color: #fff;
    text-decoration: none;
    transition: border 0.8s, background 0.8s, color 0.8s;
}

.mybutton:hover{
    border: 1px solid #333;
    color: white;
    background: #333;
    text-decoration: none;
}

.toggle-text{

    font-size: 0.8em;
    text-decoration: none;
    color: #ed1c24;
    }
	</style>


</head>
<body>
<div class="bg-image">
        <img class="desktop" title="" alt="" src="img/bg-cropped.jpg">
        <img class="mobile" title="" alt="" src="img/bg-cropped-mobile.jpg">
</div>
<!--<div id="logo">Paramount Bank</div>-->

<nav id="menu">
        <ul>
          <li><a href="login.html">Log in / Sign up</a></li>
        </ul>
      </nav>

      <div class="wrapper">

          <div class="login_form">
         <div id="form">
        <h2>Please login</h2>

        <form method="post" action="login" >
            <input type="text" name="username" placeholder="Enter your username" required=""><br/>
            <input type="password" name="password" placeholder="Enter your password" required=""><br/>
       		<p class="forward-link"><%if(request.getAttribute("error")!=null)
    	   {
    	   	out.print(request.getAttribute("error"));
    	   	out.println("- please try again");
    	   }
    	   %></p>     
            <button type="submit" name="submit" class="mybutton">submit</button>
        <br /> 
       
        <a href="#" class="toggle-text" id="show_register">create a new account</a>
     </form>      
    </div>
    </div>
    <div class="clear_both"></div>
    <div class="register_form">
    <div id="form">
    <h2>Create a new account</h2>
    <form method="post" action="signup" >
        <input type="text" name="name" placeholder="Enter your name" required=""><br>
        <input type="email" name="email" placeholder="Enter your email id" required=""><br>
        <input type="text" name="username" placeholder="Choose a username" required=""><br>
        <input type="password" name="password" placeholder="Choose a password" required=""><br>
        <button type="submit" name="submit" class="mybutton">submit</button>
    </form>
    <a href="#" class="toggle-text" id="show_register2">already have an account?</a>
    </div><!-- div form-->

      </div>
<script
  src="https://code.jquery.com/jquery-3.1.1.min.js"
  integrity="sha256-hVVnYaiADRTO2PzUGmuLJr8BLUSjGIZsDYGmIJLv2b8="
  crossorigin="anonymous"></script>
    <script type="text/javascript">$(function(){
        $('.register_form').hide();
 $('#show_register').click(function(){
        $('.login_form').hide();
        $('.register_form').show();
        return false;
    });    
 $('#show_register2').click(function(){
        $('.login_form').show();
        $('.register_form').hide();
        return false;
    });    
});</script>
</body>
</html>