/** This class is a child class of account. It has different information
 * that is specific to a money market account. It has its own too string 
 * method and constructor.
 * @author SteveWoerpel & Andy Woerpel
 */
public class MoneyMarket extends Account
{
   private static final int FEE = 12;
   private static final double APY = .0065;
   private static final double MIN_BAL = 2500;   
   private static final int WITHDRAW_LIMIT = 6;
   private int withdrawals;
   
    /**
    * This creates an object based on a name, phone number, and also sets
    * the number of withdrawals to zero.
    * @param name String
    * @param phone String
    */
   public MoneyMarket(String name, String phone)
   {
      super(name, phone);
      withdrawals = 0;
   }
    
    /**
    * This creates an object based on a name, phone number, initial 
    * balance, and date opened.
    * @param name string
    * @param phone string
    * @param balance float
    * @param d Date
    */
   public MoneyMarket(String name, String phone, float balance, Date d)
   {
      super(name, phone, balance, d);
   }
   /**
    * Creates a new MoneyMarket account that doesnt increase the account
    * number.
    * @param name String
    * @param phone String
    * @param special boolean
    */
   public MoneyMarket(String name, String phone, boolean special)
   {
      super(name, phone);
      withdrawals = 0;
      super.decreaseNumberOfAccounts();
   }
   
   /**
    * applies interest to the account based on the interest rate,
    * also deducts a fee if balance is less than the minimum balance.
    * 
    */
   public void applyInterestAndFee()
   {
         if(balance < MIN_BAL || withdrawals > WITHDRAW_LIMIT)
         {
            balance -= FEE;
         }
         balance = balance + (balance * APY) / MONTH_PER_YEAR;
   }
   
   /**
    * increases the number of withdrawals
    * @return true if the number is below the limit, false if not.
    */
   public void incrementWithdrawals()
   {
      withdrawals++;
   }
   
   public boolean withdawalsAvailable()
   {
      return withdrawals <= WITHDRAW_LIMIT;      
   }

    /**
    * converts the account number, account type, date opened, and balance
    * to a string. Also says the current number of withdrawals.
    * @return string
    */
   public String toString()
   {
      return(holder.toString() +
      "AccNum: " + Integer.toString(accNumber) + 
      " Type: Money Market " + "**" + openOn.toString() + 
      " Balance: " + Double.toString(balance) + 
      "**Withdrawals: " + withdrawals);      
   }
   
}
