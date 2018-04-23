import java.util.TimerTask;

public class TimeoutTask extends TimerTask {

    public boolean timedOut = false;

    @Override
    public void run() {
        timedOut = true;

    }
}
