<%-- 
    Document   : page5
    Created on : Apr 26, 2017, 8:12:29 PM
    Author     : marol
--%>
<!DOCTYPE html>
<%@ include file="header.jsp" %>
<a href="controller?action=main" id="back_to_page">&laquo;Back to the Main Page</a>

<%--  Display different species --%>
<br><br><h3><center>WHAT WOULD YOU LIKE TO SPONSOR FOR</center></h3>
<UL>
<br><LI><<a href="controller?action=species&species=birds"><h2>BIRDS?</h2></LI></a>
<br><LI><a href="controller?action=species&species=reptiles"><h2>REPTILES?</h2></LI></a>
<br><LI><a href="controller?action=species&species=tiger"><h2>TIGERS?</h2></LI></a>
<br><LI><a href="controller?action=species&species=peacock"><h2>PEACOCK?</h2></LI></a>
</UL>

<%@ include file="footer.jsp" %>
