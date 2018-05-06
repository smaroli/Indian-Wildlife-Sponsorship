<%-- 
    Document   : header
    Created on : Apr 19, 2017, 11:46:36 PM
    Author     : marol
--%>
<%-- Header for all pages --%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <%-- Linking style sheet--%>
    <link rel="stylesheet" href="styles/main.css">
    <div id="header">
            <nav id="header_menu">
                <ul  class="right" >
                    <%-- User login to be displayed in every page--%>
                    <c:choose>
                                <c:when test="${sessionScope.theUser != null}">
                                <li>Hello, ${sessionScope.theUser.name}</li>
                                <li><a href="controller?action=logout">Logout</a></li>
                                </c:when>
                                <c:when test="${sessionScope.theAdmin != null}">
                                <li>Hello, ${sessionScope.theAdmin.name}</li>
                                <li><a href="controller?action=logout">Logout</a></li>
                                </c:when>
                                
                    </c:choose>   
                </ul>
            </nav>
        </div>
<center><h1><u>INDIAN WILDLIFE SPONSORSHIP</h1></u></center><br>
</head>
</html>  
                  
             

            