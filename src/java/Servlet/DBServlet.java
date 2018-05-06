
package Servlet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.mail.MessagingException;
import java.util.ArrayList;

/**
 *
 * @author marol
 */
public class DBServlet {
    
     /*Code snippet to get user details*/
    public static User getUser(String email) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String type = null;
        String query = "SELECT * FROM user "
                + "WHERE Email = ?";
        
        try {   
            ps = connection.prepareStatement(query);
            ps.setString(1, email);
            rs = ps.executeQuery();
            User user = null;
            if(rs.next())
                {
                user = new User();
                user.setName(rs.getString("Name"));
                user.setEmail(rs.getString("Email"));
                user.setType(rs.getString("Type"));
            }
            return user;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }
    
    
    /* Code snippet to check if email exists*/
    public static boolean emailExists(String email) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        String query = "SELECT Email FROM user "
                + "WHERE Email = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, email);
            rs = ps.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            System.out.println(e);
            return false;
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    } 
   
   
    /*Code snippet to check if password matches*/
    public static boolean passMatch(String pass, String email) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        String query = "SELECT * FROM user "
                + "WHERE Password = ? And Email= ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, pass);
            ps.setString(2, email);
            rs = ps.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            System.out.println(e);
            return false;
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    } 
    
    
    /*Code snippet to get type of user*/
    public static String getType(String email) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String type = null;
        String query = "SELECT Type FROM user "
                + "WHERE Email = ?";
        try {   
            ps = connection.prepareStatement(query);
            ps.setString(1, email);
            rs = ps.executeQuery();
            if(rs.next())
                type = rs.getString("Type");
                return type;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }
    
    
    /*Code snippet to insert the user*/
    public static String insertUser(String email,String password,String name) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        int rs = 0;
        String query = "INSERT into user(Email,Password,Type,Name) "
                        + " values(?, ?,?,?) ";
        
        try {   
            ps = connection.prepareStatement(query);
            ps.setString(1, email);
            ps.setString(2, password);
            ps.setString(3, "P");
            ps.setString(4,name);
            
            rs = ps.executeUpdate();
            
            return "User updated";
        } catch (SQLException e) {
            System.out.println(e);
            return "User not updated";
        } finally {
            
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }
    
    /*Code snippet to get details based on species*/
    public static ArrayList<Organisation> getSpecies(String species) 
    {
        //create arraylist
        ArrayList organisationList = new ArrayList();
        //add connection pool
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        //query creation
        String query = "SELECT * FROM org "
                + "WHERE species = ? and amount > ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, species);
            ps.setInt(2, 0);
            rs = ps.executeQuery();
            Organisation organisation = null;
            while (rs.next()) {
                organisation = new Organisation();
                
                organisation.setOname(rs.getString("oname"));
                organisation.setSpecies(rs.getString("species"));
                organisation.setSpeciesco(rs.getInt("speciesco"));
                organisation.setAmount(rs.getInt("amount"));
                organisationList.add(organisation);
            }
            return organisationList;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        } 
    
}
    
    
    /*Code snippet to get details based on amount required*/
    public static ArrayList<Organisation> getListAmount(int min,int max) 
    {
        //create arraylist
        ArrayList organisationList = new ArrayList();
        //add connection pool
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        //query creation
        String query = "SELECT * FROM org "
                + "WHERE amount > ? and amount < ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, min);
            ps.setInt(2, max);
            rs = ps.executeQuery();
            Organisation organisation = null;
            while (rs.next()) {
                organisation = new Organisation();
                
                organisation.setOname(rs.getString("oname"));
                organisation.setSpecies(rs.getString("species"));
                organisation.setSpeciesco(rs.getInt("speciesco"));
                organisation.setAmount(rs.getInt("amount"));
                organisationList.add(organisation);
            }
            return organisationList;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        } 
    
}
    
    /*Code snippet to get details based on species count*/
    public static ArrayList<Organisation> getListCount(int min,int max) 
{
        //create arraylist
        ArrayList organisationList = new ArrayList();
        //add connection pool
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        //query creation
        String query = "SELECT * FROM org "
                + "WHERE speciesco > ? and speciesco < ? and amount > ? ";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, min);
            ps.setInt(2, max);
            ps.setInt(3, 0);
            rs = ps.executeQuery();
            Organisation organisation = null;
            while (rs.next()) {
                organisation = new Organisation();
                
                organisation.setOname(rs.getString("oname"));
                organisation.setSpecies(rs.getString("species"));
                organisation.setSpeciesco(rs.getInt("speciesco"));
                organisation.setAmount(rs.getInt("amount"));
                organisationList.add(organisation);
            }
            return organisationList;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        } 
    
}
    
    
    /*Code snippet to get entire list*/
    public static ArrayList<Organisation> getList() 
    {
        //create arraylist
        ArrayList organisationList = new ArrayList();
        //add connection pool
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        //query creation
        String query = "SELECT * FROM org "
                + "WHERE amount > ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, 0);
            rs = ps.executeQuery();
            Organisation organisation = null;
            while (rs.next()) {
                organisation = new Organisation();
                
                organisation.setOname(rs.getString("oname"));
                organisation.setSpecies(rs.getString("species"));
                organisation.setSpeciesco(rs.getInt("speciesco"));
                organisation.setAmount(rs.getInt("amount"));
                organisationList.add(organisation);
            }
            return organisationList;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        } 
    
}
    
    
    
    /*Code snippet to get sponsor list*/
    public static ArrayList<Organisation> getSponsors() 
    {
        //create arraylist
        ArrayList organisationList = new ArrayList();
        //add connection pool
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        //query creation
        String query = "SELECT * FROM sponsor "
               + "WHERE status = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, "n");
            
            rs = ps.executeQuery();
            Organisation organisation = null;
            while (rs.next()) {
                organisation = new Organisation();
                
                organisation.setOname(rs.getString("oname"));
                organisation.setName(rs.getString("Name"));
                organisation.setEmail(rs.getString("Email"));
            
                organisation.setAmount(Integer.parseInt(rs.getString("amount")));
                organisationList.add(organisation);
            }
            return organisationList;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        } 
    
}
    
    /*Code snippet to get send email*/
    public static String SendEmail(String email,String name) 
{
        
        String to = email;
        String from = "test1234567@gmail.com";
         String subject = "Indian Wildlife Sponsorship - Thank You";           
         String body = "Dear " + name +  "\n \n Thanks for showing your interest in sponsoring for Indian wildlife. "    
                 + "We have your information. Our team will get back to you regarding payment. "         
             
                       
                 + "Have a great day and thanks again!\n\n"         
                 + "\n"  
                 + "Best Regards, \n"
                 + "Indian Wildlife Sponsorship Team";     
         boolean isBodyHTML = false;         
         try {         
             MailUtilLocal.sendMail(to, from, subject, body,isBodyHTML);
               return "success";
         }      
       catch (MessagingException e)
       {             
           String errorMessage = "ERROR: Unable to send email. "    
                   + "Check Tomcat logs for details.<br>"             
                   + "NOTE: You may need to configure your system "   
                   + "as described in chapter 14.<br>"              
                   + "ERROR MESSAGE: " + e.getMessage();         
           return errorMessage;            
       }      
}
 
    
 /*Code snippet to insert details to sponsor table*/
 public static String insertSponsor(String email,String name,String amount,String oname)
 {
      ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        int rs = 0;
        //query creation
        String query = "INSERT into sponsor(email,name,amount,oname,status) "
                        + " values(?, ?,?,?,?) ";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, email);
            ps.setString(2, name);
            ps.setString(3,amount);
            ps.setString(4,oname);
            ps.setString(5, "n");
            rs = ps.executeUpdate();
            return "Sponsor updated";
          
      } 
       
        catch (SQLException e) {
            System.out.println(e);
            return "Error while updating";
        } 
        finally {

            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
 }

 
/*Code snippet to modify amount once received*/
public static String addAmount(String oname,int amount, int amount1)
 {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps1 = null;
        int rs1 = 0;
        PreparedStatement ps2 = null;
        int rs2 = 0;
        int sum = 0;
        sum = (amount1 - amount);
        //query creation
        String query1 = "update org set amount=? where oname=? ";
        String query2 = "update sponsor set status=? where oname=? ";
        try {
            ps1 = connection.prepareStatement(query1);
            ps1.setInt(1, sum);
            ps1.setString(2, oname);
            rs1 = ps1.executeUpdate();
            ps2 = connection.prepareStatement(query2);
            ps2.setString(1, "r");
            ps2.setString(2, oname);
            rs2 = ps2.executeUpdate();
            return " updated";
          
      } 
       
        catch (SQLException e) {
            System.out.println(e);
            return "Error while updating";
        } 
        finally {

            DBUtil.closePreparedStatement(ps1);
            DBUtil.closePreparedStatement(ps2);
            pool.freeConnection(connection);
        }
 }

/*Code snippet to get amount based on org*/
public static int getAmount(String oname)
 {
       ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        int result = 0;
        
        String query = "SELECT * FROM org "
                + "WHERE oname = ?" ;
        try {   
            ps = connection.prepareStatement(query);
            ps.setString(1, oname);
           
            rs = ps.executeQuery();
            if(rs.next())
            {
                result = rs.getInt("amount");
            }
               return result;
            
           
        } catch (SQLException e) {
            System.out.println(e);
            return 0;
        } 
        finally {
           DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
 }

}
