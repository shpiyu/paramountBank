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
            <li><a href="enquiry.jsp">Balance Enquiry</a></li>
            <li><a href="transfer.html">Fund Transfer</a></li>          
            <li><a href="newaccount.html">New Account</a></li>

            <li><a href="logout.jsp">Log out</a></li>

        </ul>
      </nav>

      <div class="wrapper">
        <div class="text-container">
            <h2>Oh snap :( </h2>
            <h4>Something went wrong!</h4>
            <p><%=request.getAttribute("error") %></p>
            
            <p><a href="javascript:history.back()" class="forward-link">Go Back</a> </p>
        </div>
      </div>
</body>
</html>