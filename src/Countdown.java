import java.util.Timer;
import java.util.TimerTask;
public class Countdown {

    int delay = 0;
    String ending;

    public void countDown(Countdown countDown, int delay) {
        this.delay = (delay - 1);
        countDown.timer.schedule(countDown.task, delay);
    }

    Timer timer = new Timer();
    TimerTask task = new TimerTask() {
        @Override
        public void run() {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    };

    public void countDown(Countdown countDown, int delay, String ending) {
        this.delay = (delay - 1);
        this.ending = ending;
        countDown.timerEnding.schedule(countDown.taskEnding, delay);
    }

    Timer timerEnding = new Timer();
    TimerTask taskEnding = new TimerTask() {
        @Override
        public void run() {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            GameEnding.ending.GameEnding(ending);
        }
    };
}