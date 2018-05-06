<%-- 
    Document   : page2
    Created on : Apr 22, 2017, 5:00:25 PM
    Author     : marol
--%>

<%@ include file="header.jsp" %>

<%--  Login form --%>
<a href="controller?action=home" id="back_to_page">&laquo;Back to the Home Page</a>
<body>
<section id ="page2">
<form action="controller?action=login" method="post">
<span id="error"><c:out value="${msg}" /></span>
<br><br><center>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Email:<input type="email" name="email" required></center>
<br><br><center>Password:<input type="password" name="password" required/></center><br><br>
<center><input type="submit" value="Login"></center><br><br>
</form>
</section>
</body>
  

<%@ include file="footer.jsp" %>