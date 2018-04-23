package action;

import Statistic.Record;
import Statistic.RecordLoader;

public class DisplayStatsAction extends Action {

    public DisplayStatsAction(String text){
        super(text);
    }

    @Override
    public void execute() {
        try {
            Record record = RecordLoader.load("data/Records.dat");
            record.showTable();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
