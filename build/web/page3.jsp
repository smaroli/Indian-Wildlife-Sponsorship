<%-- 
    Document   : page3
    Created on : Apr 23, 2017, 11:03:43 PM
    Author     : marol
--%>

<%@ include file="header.jsp" %>
<a href="controller?action=home" id="back_to_page">&laquo;Back to the Home Page</a>
<%--  Sign Up form --%>
<body>
<section id ="page2">
<form action="controller?action=signup" method="post">
<span id="error"><c:out value="${msg}" /></span>
<br><br><center>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Name    :<input type="text" name="name" required/></center>
<br><br><center>&nbsp;&nbsp;&nbsp;Email   :<input type="email" name="email" required></center>
<br><br><center>Password:<input type="password" name="password" required/></center>
<br><br><center>Re-Enter:<input type="password" name="confirm_password" required/></center>
<br><br><center><input type="submit" value="Sign Up"></center><br><br>
</form>
</section>
</body>
  

 <%@ include file="footer.jsp" %>
