package parkings;


import java.io.Serializable;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.io.*;
import java.util.*;

public class Book implements Serializable
{
    private static final long serialVersionUID = 1L;
    String number;
    public static final String car_number = "number";
    String owner;
    public static final String car_owner = "owner";
    Date startdate = new Date();
    public static final String start_date = "start_date";
    static final SimpleDateFormat format = new  SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    Date enddate = new Date();
    String annotation ;
    String dur ;
    public static final String Dur = "Park_time";
    public static final String end_date = "end_date";

    double price;
    public static final String P_price = "Price";

    public static final String P_ANNOTATION = "Annotation";



    public static final String AREA_DEL = "\n";

    public String getStrISBN() {
        return number;
    }

    public final void setAnnotation(String strnum) {

        this.annotation = strnum;
    }

    public final void setStrnum(String strnum) {
        if (strnum == null || strnum.isEmpty()) {
            throw new IllegalArgumentException("Illegal number");
        }
        this.number = strnum;
    }

    public String getowner() {
        return owner;
    }

    public final void setowner(String owner) {
        if (owner == null || owner.isEmpty()) {
            throw new IllegalArgumentException("Illegal owner");
        }
        this.owner = owner;
    }


    public double getPrice() {
        return price;
    }

    public final void setPrice(String strPrice) {
        boolean isError = false;
        double p = 0;
        try {
            p = Double.parseDouble(strPrice);
        } catch (Error | Exception e) {
            isError = true;
        }
        if (isError || p <= 0) {
            throw new IllegalArgumentException("Illegal price");
        }
        this.price = p;
    }
    public final void setparktime(String strDur) throws ParseException{
        this.enddate=format.parse(strDur);

    }

    public String getparktime()
    {
        long difference_In_Time = enddate.getTime() - startdate.getTime();
        dur ="" + difference_In_Time;
        return dur;
    }

    public final void setend_datepark(String endpark) throws ParseException {
        this.enddate=format.parse(endpark);
    }

    public final void setstart_datepark(String startpark) throws ParseException {
        this.startdate=format.parse(startpark);
    }




    public static boolean nextRead(Scanner fin, PrintStream out) {
        return nextRead(car_number, fin, out);
    }

    static boolean nextRead(final String prompt, Scanner fin, PrintStream out) {
        out.print(prompt);
        out.print(": ");
        return fin.hasNextLine();
    }

    public static final String authorDel = ",";

    public static Book read(Scanner fin, PrintStream out) throws IOException,
            NumberFormatException, ParseException {
        String str;
        Book par = new Book();
        par.number = fin.nextLine().trim();

        if (!nextRead(car_owner, fin, out)) {
            return null;
        }
        par.owner = fin.nextLine();
        if (!nextRead(start_date, fin, out)) {
            return null;
        }

        par.startdate=format.parse(fin.nextLine());

        if (!nextRead(end_date, fin, out)) {
            return null;
        }
        par.enddate=format.parse(fin.nextLine());


        if (!nextRead(P_price, fin, out)) {
            return null;
        }
        str = fin.nextLine();
        par.price = Double.parseDouble(str);
        return par;
    }

    public Book() {
    }

    public static final String areaDel = "\n";

    public String toString() {
        return new String(
                number + areaDel +
                        owner + areaDel +
                        startdate + areaDel +
                        enddate+ areaDel +
                        price
        );
    }
}
