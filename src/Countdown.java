import java.util.Timer;
import java.util.TimerTask;
import java.io.*;

public class Countdown{

    private static String str = "";

    static TimerTask task = new TimerTask() {
        @Override
        public void run() {
            if(str.equals("")){
                System.out.println("Fields empty");
                System.exit(0);
            }
        }
    };

    public Countdown(){

    }


    public static void run() throws Exception {
        Timer timer = new Timer();
        timer.schedule( task, 10*1000 );

        System.out.println( "Input a string within 10 seconds: " );
        BufferedReader in = new BufferedReader(
                new InputStreamReader( System.in ) );
        str = in.readLine();

        timer.cancel();
        System.out.println( "you have entered: "+ str );


    }


}