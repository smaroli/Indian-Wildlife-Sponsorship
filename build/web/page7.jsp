<%-- 
    Document   : page7
    Created on : Apr 26, 2017, 9:08:54 PM
    Author     : marol
--%>

 <%@ include file="header.jsp" %>
 <a href="controller?action=main" id="back_to_page">&laquo;Back to the Main Page</a>
<body>
    
<%-- Range of species to be displayed forms--%>
<table id="my_studies_table" >
    <form action="controller?action=count" method="post">
        <tr>
            <td>ENTER THE RANGE FOR SPECIES COUNT IN THE ORGANISATION</td>
            <td>MIN/MAX VALUES</td>
        </tr>
        <tr>
            <td>The organisation should have species more than:</td> 
            <td><input type ="text" name="min" value="0"></td>
        </tr>
        <tr>
            <td>The organisation should have species less than:</td>
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
