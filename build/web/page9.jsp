<%-- 
    Document   : page9
    Created on : Apr 26, 2017, 9:14:08 PM
    Author     : marol
--%>

<%@ include file="header.jsp" %>

 <%-- Code to go Back to the Main Page  --%>
<a href="controller?action=main" id="back_to_page">&laquo;Back to the Main Page</a>
 
 <%--page which displays all org details based on the input selected --%>
<section id="studies_section">
        <table id="my_studies_table" >
        <tr>
            <th>Organization Name</th>
            <th>Species</th>		
            <th>Count of the species</th>
            <th>Amount Required</th>
            <th>Action</th>
        </tr>
        <tr>            
            <c:forEach items="${theOrganisation}" var="entry">
            <td>${entry.oname}</td>
            <td>${entry.species}</td>
            <td>${entry.speciesco}</td>
            <td>${entry.amount}</td>
            <td>
                <form action="controller" method="post">
                    <input type="hidden" name="action" value="sponsor">        
                    <input type="hidden" name="oname" value="${entry.oname}"> 
                    <input type ="text" name="spamount" value="5">
                    <input type ="hidden" name="name" value="${sessionScope.theUser.name}">
                    <input type ="hidden" name="email" value="${sessionScope.theUser.email}">
                    <button type="submit">Sponsor</button>
                </form>
            </td>
        </tr>
    </c:forEach>
    </table>    
</section>
 
<%-- Include tag is used to import footer page --%>
<%@ include file="footer.jsp" %>

