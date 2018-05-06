package Servlet;
import java.io.Serializable;
/**
 *
 * @author marol
 */

/*Class implements Serializable*/
public class Organisation implements Serializable {
 
/*Instance variables*/
private String Oname;
private String Species;
private int Speciesco;
private int Amount;
private String Name;
private String Email;

/*Zero argument constructor*/
public Organisation()
{
   this.Oname = "";
   this.Species = "";
   this.Speciesco = 0;
   this.Amount = 0;
   this.Name = "";
   this.Email = "";
}
/*get and set methods for org Name*/
public String getOname()
{
    return Oname;
}
public void setOname(String Oname)
{
    this.Oname   = Oname;
}
/*get and set methods for species*/
public String getSpecies()
{
    return Species;
}
public void setSpecies(String Species)
{
    this.Species   = Species;
}
/*get and set methods for species count*/
public int getSpeciesco()
{
    return Speciesco;
}
public void setSpeciesco(int Speciesco)
{
    this.Speciesco   = Speciesco;
}

public int getAmount()
{
    return Amount;
}
public void setAmount(int Amount)
{
    this.Amount   = Amount;
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

}

