
package Servlet;
import java.io.Serializable;
/**
 *
 * @author marol
 */

/*Class implements Serializable*/
public class User implements Serializable {
 
/*Instance variables*/
private String Name;
private String Email;
private String Type;
/*Zero argument constructor*/
public User()
{
   this.Name = "";
   this.Email = "";
   this.Type = "";
}
/*get and set methods for Name*/
public String getName()
{
    return Name;
}
public void setName(String Name)
{
    this.Name   = Name;
}
/*get and set methods for Email*/
public String getEmail()
{
    return Email;
}
public void setEmail(String Email)
{
    this.Email   = Email;
}
/*get and set methods for Type*/
public String getType()
{
    return Type;
}
public void setType(String Type)
{
    this.Type   = Type;
}

}
