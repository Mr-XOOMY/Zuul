import java.util.Timer;
import java.util.TimerTask;
import java.io.*;

public class Countdown{

    private static String str = "";
    static Timer timer = new Timer();
    static TimerTask task = new TimerTask() {
        @Override
        public void run() {
            if(str.equals("")){
                System.out.println("Fields empty");
                System.exit(0);
            }
        }
    };

    public void run() {
        
        timer.schedule( task, 10*1000 );

        System.out.println( "Input a string within 10 seconds: " );
        BufferedReader in = new BufferedReader(
                new InputStreamReader( System.in ) );
        try {
            str = in.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        timer.cancel();
        System.out.println( "you have entered: "+ str );


    }


}