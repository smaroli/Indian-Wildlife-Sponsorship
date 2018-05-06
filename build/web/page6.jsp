<%-- 
    Document   : page6
    Created on : Apr 26, 2017, 8:12:43 PM
    Author     : marol
--%>

<%@ include file="header.jsp" %>
<a href="controller?action=main" id="back_to_page">&laquo;Back to the Main Page</a>
<body>
    
<%-- Range of amount to be displayed forms--%>
<table id="my_studies_table" >
    <form action="controller?action=amount" method="post">
        <tr>
            <td>ENTER THE RANGE FOR AMOUNT REQUIRED BY THE ORGANIZATION</td>
            <td>MIN/MAX VALUES</td>
        </tr>
        <tr>
            <td>The organisation should have amount required more than:</td>
            <td><input type ="text" name="min" value="0"></td>
        </tr>
        <tr>
            <td>The organisation should have amount required less than:</td>
            <td><input type ="text" name="max" value="0"></td>
        </tr>
        <tr>
            <td></td>
            <td><button type="submit">Submit</button> </td>
        </tr>
      </form>
</table>
</body>

<%@ include file="footer.jsp" %>
