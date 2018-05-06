
package Servlet;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import Servlet.User;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpSession;

/**
 *
 * @author marol
 */
public class ControllerServlet extends HttpServlet{
    protected void doPost(HttpServletRequest request,
        HttpServletResponse response)
                throws ServletException, IOException {
    String url = "/page1.jsp";
    String msg = "";
    HttpSession session = request.getSession();
    //get current action
    String action = request.getParameter("action");
    if(action==null)
    {
          action = "initial";
    }
    
    //set appropriate url
    if(action.equals("initial"))
    {
          url = "/page1.jsp";
    }
    
/*if action is login*/
else if (action.equals("login")) {
           String email = request.getParameter("email");
           String pass = request.getParameter("password");
           if(DBServlet.emailExists(email))
           {
            if(DBServlet.passMatch(pass,email))
            {
                String type = DBServlet.getType(email);
                if(type.equals("P"))
                {
                    User user = DBServlet.getUser(email);
                    session.setAttribute("theUser", user);
                    url = "/page4.jsp";
                    
                }
                else
                {
                    User user = DBServlet.getUser(email);
                    session.setAttribute("theAdmin", user);
                    ArrayList<Organisation> organisationList = new ArrayList();
                    organisationList = DBServlet.getSponsors();
                    request.setAttribute("theOrganisation", organisationList);
                     url = "/admin.jsp";
                }
            }
            else
            {
               msg = "ERROR:Password don't match.Please try again"; 
               url = "/page2.jsp";
            }
                
           }
           else
           {
            msg = "ERROR:User doesnot exist";
            url = "/page2.jsp";
           }
}
    
/*if action is logout*/
else if (action.equals("logout"))
{
          if (session.getAttribute("theUser") != null || session.getAttribute("theAdmin") != null) 
          {
          session.removeAttribute("theUser");
          session.removeAttribute("theAdmin");
          url = "/page1.jsp";
          }
          else
          {
          url = "/page1.jsp";
          }
}
    
    
/*if action is signup*/
else if (action.equals("signup"))
    {
           String email = request.getParameter("email");
           String name = request.getParameter("name");
           String type = "P";
           String pass1 = request.getParameter("password");
           String pass2 = request.getParameter("confirm_password"); 
           if(DBServlet.emailExists(email))
           {
               msg = "ERROR:Email already exists";
               url = "/page3.jsp";
           }
               
           else if(!pass1.equals(pass2))
           {
               msg = "ERROR:Password don't match.Please try again";
               url = "/page3.jsp";
           }
           else 
           {
               
               DBServlet.insertUser(email, pass2, name);
               User user = DBServlet.getUser(email);
               session.setAttribute("theUser", user);
               url = "/page4.jsp";
           }
}
     
/*if action is display based on species*/     
else if (action.equals("species"))
{
           String species = request.getParameter("species");
           if (session.getAttribute("theUser") != null)
         {

          ArrayList<Organisation> organisationList = new ArrayList();
          organisationList = DBServlet.getSpecies(species);
          request.setAttribute("theOrganisation", organisationList);
          
          url ="/page9.jsp";
                
          }
          else
          url ="/page1.jsp";
}

/*if action is display based on amount required*/
else if (action.equals("amount"))
{
           int min = Integer.parseInt(request.getParameter("min"));
           int max = Integer.parseInt(request.getParameter("max"));
           if (session.getAttribute("theUser") != null)
         {

          ArrayList<Organisation> organisationList = new ArrayList();
          organisationList = DBServlet.getListAmount(min,max);
          request.setAttribute("theOrganisation", organisationList);
          
          url ="/page9.jsp";
                
          }
          else
          url ="/page1.jsp";
}


/*if action is display based on species count*/
else if (action.equals("count"))
{
           int min = Integer.parseInt(request.getParameter("min"));
           int max = Integer.parseInt(request.getParameter("max"));
           if (session.getAttribute("theUser") != null)
         {

          ArrayList<Organisation> organisationList = new ArrayList();
          organisationList = DBServlet.getListCount(min,max);
          request.setAttribute("theOrganisation", organisationList);
          
          url ="/page9.jsp";
                
          }
          else
          url ="/page1.jsp";
}

/*if action is display whole list*/
else if (action.equals("list"))
    {
           if (session.getAttribute("theUser") != null)
         {

          ArrayList<Organisation> organisationList = new ArrayList();
          organisationList = DBServlet.getList();
          request.setAttribute("theOrganisation", organisationList);
          
          url ="/page9.jsp";
                
          }
          else
          url ="/page1.jsp";
}

 /*if action is sponsor*/
else if (action.equals("sponsor"))
{
String email = request.getParameter("email");
String name = request.getParameter("name");
String amount = request.getParameter("spamount");
String oname = request.getParameter("oname");
DBServlet.insertSponsor(email,name,amount,oname);
DBServlet.SendEmail(email,name);

url = "/page11.jsp";
          
}

 /*if action is admin action*/
else if (action.equals("received"))
{
String oname = request.getParameter("oname");
int amount = Integer.parseInt(request.getParameter("spamount"));
int amount1 = DBServlet.getAmount(oname);
//int sum = 0;
//sum = amount1 - amount;
//msg = "sum is " + amount1;
url = "/admin.jsp";
DBServlet.addAmount(oname,amount,amount1);          
}
else if (action.equals("main"))
    {
          if (session.getAttribute("theUser") != null)
          {
                url = "/page4.jsp";
            } 
          else if(session.getAttribute("theAdmin") != null)
                  {
                url = "/admin.jsp";
           }
          else
          {
              url = "/page1.jsp";
          }
}

 /*if action is any other*/
else
{
        url = "/page1.jsp"; 
}
    
request.setAttribute("msg", msg);
getServletContext()
.getRequestDispatcher(url)
.forward(request,response);
    
}
    
 /*GET method*/
@Override
protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
               throws ServletException, IOException
{
        doPost(request, response);
}   
}
    
