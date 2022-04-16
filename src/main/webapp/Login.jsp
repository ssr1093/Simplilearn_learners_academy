<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
.header:active {
	
}
</style>
<meta charset="UTF-8">
<title>Learners Academy</title>

</head>
<body>
<div class="header">
<header>
		<nav class="Header"
			style="background-color: #BABE66">
			
				<h1 style="text-align: center;":>Learners Academy</h1>
			
					</nav>
</header>
</div>
<div style="text-align: Center">
<h1>Administration Login</h1>
<div class="contain">
<form action="Login" method="POST">  
        <div class="container">   
            <label>Username : </label>   
            <br/>
            <input type="text" placeholder="Enter Username" name="username" required>  
            <br/>
            <label>Password : </label>   
            <br/>
            <input type="password" placeholder="Enter Password" name="password" required>  
            <br/>
            <button type="submit">Login</button>   
            <br/>   
             
        </div>   
    </form>   
  </div>
  </div>  
</body>
</html>