package action;

import Statistic.Record;
import Statistic.RecordLoader;

public class DisplayStatsAction extends Action {

    public DisplayStatsAction(String text){
        super(text);
    }

    @Override
    public void execute() {
        String filename = "Records.dat";

        Record r = new Record();

        try {
            r = RecordLoader.load(filename);
        } catch (Exception e) {
            // Do nothing
        }
        r.showTable();

    }
}
