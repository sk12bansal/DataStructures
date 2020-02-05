import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateSorting {
    public static void main(String []args){
        DateFormat fd = new SimpleDateFormat("dd MMM yyyy");

        String data = "25 FEB 2005";
        Date date = new Date("15 FEB 2005");

        // date = fd.format(data);
        System.out.println(fd.format(date));


        Calendar cal = Calendar.getInstance();
        SimpleDateFormat dateOnly = new SimpleDateFormat("dd MMM yyyy");
        System.out.println(dateOnly.format(cal.getTime()));
    }
}
