<%-- 
    Document   : page9
    Created on : Apr 26, 2017, 9:14:08 PM
    Author     : marol
--%>

 <%-- Include header  --%>
<%@ include file="header.jsp" %>

<%-- Header to display the sponsor details --%>
<section id="studies_section">

        <table id="my_studies_table" >
        <tr>
            <th>Organization Name</th>
            <th>Name of the sponsor</th>		
            <th>Email</th>
            <th>Action</th>
        </tr>
        <tr>
            <%-- Looping org details --%>
            <c:forEach items="${theOrganisation}" var="entry">
            <td>${entry.oname}</td>
            <td>${entry.name}</td>
            <td>${entry.email}</td>
            <td>
                <form action="controller" method="post">
                    <input type="hidden" name="action" value="received">        
                    <input type="hidden" name="oname" value="${entry.oname}"> 
                    <input type ="text" name="spamount" value="${entry.amount}">
                    <button type="submit">Amount received</button>
                </form>
            </td>

        </tr>
    </c:forEach>
    </table>



</section>
<%-- Include tag is used to import footer page --%>
<%@ include file="footer.jsp" %>


