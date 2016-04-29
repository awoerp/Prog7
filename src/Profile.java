/**This class creates profile objects that get attached to accounts when
 * created. It contains two equals methods and a specific to string method
 * @author SteveWoerpel & AndyWoerpel
 */
public class Profile 
{
   private String name;
   private String phone;
   
   /**
    * creates a profile object based on a name and phone number
    * @param n String
    * @param p String
    */
   public Profile(String n, String p)
   {
      name = n;
      phone = p;
   }
   
   /**
    * compares two profiles based on name and phone
    * @param p profile object
    * @return true if both are equal, false if not
    */
   public boolean equals(Profile p)
   {
      return(name.equals(p.name) && phone.equals(p.phone));
   }
   
   /**
    * compares two profiles based on name and phone
    * @param n String
    * @param p String
    * @return true if they are equal, false if not
    */
   public boolean equals(String n, String p)
   {

      return(n.equals(name) && p.equals(phone));
   }
   
   /**
    * returns profile information as a string
    * @return String
    */
   /**
   public String toString()
   {
      return("Name:                         " + name + "\n" +
             "Phone:                        " + phone + "\n");
   }
   */
   public String toString()
   {
      return(name + "**" + phone + "**");
   }
   
   /**
    * returns name of profile
    * @return String
    */
   public String getName()
   {
      return name;
   }
   
   /**
    * returns phone number of profile
    * @return String
    */
   public String getPhoneNumber()
   {
      return phone;
   }
   
}
