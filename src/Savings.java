/** This class is a child class of account. It has different information
 * that is specific to a savings account. It has its own too string 
 * method and constructor.
 * @author SteveWoerpel & Andy Woerpel
 */
public class Savings extends Account
{
   private static final int FEE = 5;
   private static final double APY = .0025;
   private static final double APYS = .0035;
   private static final double MIN_BAL = 300;
   private boolean special; // the interest rate is .35 if this is true
   
   /**
   * This creates an object based on a name, phone number, and the option
   * of creating a special savings account.
   * @param name String
   * @param phone String
   * @param ssa boolean
   */
   public Savings(String name, String phone, boolean ssa)
   {
      super(name, phone);
      special = ssa;
   }
   
   /**
    * creates a new savings account without increasing account number.
    * @param name String
    * @param phone String
    */
   public Savings(String name, String phone)
   {
      super(name, phone);
      special = false;
      super.decreaseNumberOfAccounts();
   }
   
   /**
    * This creates an object based on a name, phone number, initial 
    * balance, date opened, and if it is direct deposit or not
    * @param name string
    * @param phone string
    * @param balance float
    * @param d Date
    * @param ss boolean
    */
   public Savings(String name, String phone, float balance, Date d,  boolean ss)
   {
      super(name, phone, balance, d);
      special = ss;
   }
   
   /**
    * applies interest to the account based on the interest rate,
    * also deducts a fee if balance is less than the minimum balance.
    * If it is a special savings account, there is a different interest
    * rate.
    */
   public void applyInterestAndFee()
   {
         if(balance < MIN_BAL)
         {
            balance -= FEE;
         }
         if(special)
         {
            balance = balance + (balance * APYS) / MONTH_PER_YEAR;
         }
         else
         {
            balance = balance + (balance * APY) / MONTH_PER_YEAR;
         }
   }
   
   /**
    * converts the account number, account type, date opened, and balance
    * to a string. Also says if it is a special savings account.
    * @return string
    */
   public String toString()
   {
      String specialAccount;
      if(special)
         specialAccount = "special";
      else
         specialAccount = "regular";
      return(holder.toString() + "AccNum: " + 
         Integer.toString(accNumber) + 
         " Type: Savings " + "**" + openOn.toString() + 
         "**" + specialAccount + 
         " Balance: " + Double.toString(balance));
                 
   }
}

