import java.util.Timer;
import java.util.TimerTask;
public class Countdown {

    Timer timer = new Timer();
    TimerTask task = new TimerTask() {
        @Override
        public void run() {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            System.out.println("Too late");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException tits) {
                tits.printStackTrace();
            }
           // System.exit(0);
        }
    };
}