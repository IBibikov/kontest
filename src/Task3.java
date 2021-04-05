
import java.io.PrintWriter;
import java.util.*;

public class Task3{
    int ask(Scanner in,PrintWriter out,String query){
        out.println("? "+query);
        out.flush();
        String answer= in.next();
        if (answer.equals("!")){
            System.exit(0);
        }
        return in.nextInt();
    }
    final TimeZone tz= TimeZone.getTimeZone("GMT");
    final Locale locale = Locale.FRANCE;
    final Calendar calendar= Calendar.getInstance(tz,locale);

    String numToDate(int n){
        calendar.set(1970,0,1,12,0,0);
        calendar.add(Calendar.DAY_OF_MONTH,n);
        int year= calendar.get(Calendar.YEAR);
        int month= calendar.get(Calendar.MONTH)+1;
        int day= calendar.get(Calendar.DAY_OF_MONTH);
        return String.format("%02d.%02d.%04d",day,month,year);
    }
    int dateToNum(String s){
        int day = Integer.parseInt(s.substring(0,2));
        int month =Integer.parseInt(s.substring(3,5));
        int year =Integer.parseInt(s.substring(6,10));
        calendar.set(year,month-1,day,12,0,0);
        long ms=calendar.getTimeInMillis();
        calendar.set(1970,0,1,12,0,0);
        ms-=calendar.getTimeInMillis();
        final long msPerDay= 86400000;
        return (int)((ms+msPerDay/2)/msPerDay);
    }
    void selfTest(){
        System.err.println(numToDate(0));
        System.err.println(numToDate(30*366));
        for(int i =0;i<30*366;i++){
            String s =numToDate(i);
            int i2= dateToNum(s);
            if (i!=i2){
                System.out.println(i+" "+s+" "+i2);
                System.exit(0);
            }
        }
        System.err.println("OK");
    }

    void solve (Scanner in, PrintWriter out ){
        int maxQueries = in.nextInt();
        int totalEvents = ask(in,out,"31.12.2020");
        int left = dateToNum("01.01.1970") + totalEvents/2-1;
        int right = dateToNum("31.12.2020") - totalEvents/2;
        while(left+1<right){
            int mid=(left+right)/2;
            int res = ask(in,out,numToDate(mid));
            if (res < totalEvents/2+1){
                left = mid;
            } else {
                right=mid;
            }
        }
        out.println("! "+numToDate(right));
    }
    void run(){
        try (
                Scanner in = new Scanner(System.in);
                PrintWriter out= new PrintWriter(System.out)
        ){
            solve(in,out);
        }
    }

    public static void main(String[] args) {
        new Task3().run();
    }
}