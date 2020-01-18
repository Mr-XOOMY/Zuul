import java.util.Timer;
import java.util.TimerTask;
public class Countdown {

    //static Countdown countDown = new Countdown();
    int delay = 0;

    public void countDown(Countdown countDown, int delay) {
        this.delay = delay;
        countDown.timer.schedule(countDown.task, delay);
    }

    Timer timer = new Timer();
    TimerTask task = new TimerTask() {
        @Override
        public void run() {
            try {
                Thread.sleep(delay);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            // use game-over function
            Music.musicObject.getDevice().stop();
            Music.musicObject.getDevice().close();
            Item.itemObject.roomId = null;
            Menu.menu.menu();
        }
    };
}