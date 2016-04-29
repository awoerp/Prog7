/**
 This class handles everything associated with the date.
 It creates dates, checks if they are valid, changes them to strings,
 and checks if two dates are equal.
 @author Steven Woerpel & Andy Woerpel
 */
import java.util.Calendar;
import java.util.Locale;
import java.util.StringTokenizer;

public class Date implements Comparable
{
   public static final int MONTHS_IN_YEAR = 12;
   private int  day;
   private int  month;
   private int  year;

   
   /**
    * creates new date based on the actual current date.
    */
   public Date()
   {
      Calendar c = Calendar.getInstance();
      this.day = c.get(Calendar.DAY_OF_MONTH);
      this.month = c.get(Calendar.MONTH) + 1;
      this.year = c.get(Calendar.YEAR);
   }
   /**
   Creates a date object based on a string that is passed when called
    * @param d date as a string 
    */
   public Date(String d)
   {
      StringTokenizer st = new StringTokenizer(d,"/");
      month = Integer.parseInt(st.nextToken());
      day = Integer.parseInt(st.nextToken());
      year = Integer.parseInt(st.nextToken()); 
      //use StringTokenizer to parse the String
   }
   
   /**
    * Creates a date object copied from a given object.
    * @param d date object
    */
   public Date(Date d)
   {
      day = d.day;
      month = d.month;
      year = d.year;
      //this is a constructor
   }  
   
   /**
    * Checks to see if a date is valid based on a valid year
    * month, and a valid day within the month depending on the days in 
    * that specific month. Also handles leap years based on the year.
    * @return true if date is valid, false if not
    */
   public boolean isValid()
   {
      if(year > 0 && year < 2100)
      {
         if((day > 0 && day <= Month.DAYS_ODD) && 
            (month > 0 && month <= MONTHS_IN_YEAR))
         {
            if(month == Month.JAN || month == Month.MAR ||
               month == Month.MAY || month == Month.JUL ||
               month == Month.AUG || month == Month.OCT || month == Month.DEC)
            {
               if(day <= Month.DAYS_ODD)
                  return true;
            }
            else if(month == Month.APR || month == Month.JUN ||
                    month == Month.SEP || month == Month.NOV)
            {
               if(day <= Month.DAYS_EVEN)  
                  return true;
            }
            else if(month == Month.FEB && day <= Month.DAYS_FEB)
            {
               return true;
            }
            else if((year % Month.QUADRENNIAL) == 0 && (year % Month.CENTENNIAL)
                    != 0 || (year % Month.CENTENNIAL == 0) && 
                    (year % Month.QUATERCENTENNIAL == 0))
               return true;
         }
         return false;  
      }
      return false;
   }
   
   /**
    * changes date to a string
    * @return date in format MM/DD/YYYY 
    */
   @Override
   public String toString()
   {
      return (Integer.toString(month) + '/' + day + '/' + year);
   }
   
   /**
    * Checks if two date objects are equal based on if their days, months,
    * and years are all equal.
    * @param obj
    * @return true if two dates are equal, false if they are not
    */
   @Override
   public boolean equals(Object obj)
   {
      if(obj instanceof Date)
      {
         Date temp = (Date) obj;
         return (temp.day == day &&
                 temp.month == month &&
                 temp.year == year);
      }
      return false;
   }
   
   /**
   Compare “this” with (Date) o; if “this” is before o, return -1; if “this” is equal
   to o return 0; if “this” is after o, return 1.
   * 
   */
   public int compareTo(Object obj)
   {
      Date dateObj = (Date) obj;
      java.util.Date thisDate = new java.util.Date(year, month, day);
      java.util.Date testDate = new java.util.Date(dateObj.year,
                                                   dateObj.month,
                                                   dateObj.day);
      int returnVal = thisDate.compareTo(testDate);
      return returnVal;
   }
}