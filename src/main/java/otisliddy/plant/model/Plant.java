package otisliddy.plant.model;

import lombok.Data;
import otisliddy.plant.model.activity.AnnualActivity;
import otisliddy.plant.model.activity.Divide;
import otisliddy.plant.model.activity.Feed;
import otisliddy.plant.model.activity.OtherActivity;
import otisliddy.plant.model.activity.PlantActivity;
import otisliddy.plant.model.activity.ProtectFromFrost;
import otisliddy.plant.model.activity.Prune;
import otisliddy.plant.model.activity.TakeCuttings;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;

import static otisliddy.plant.StringUtils.isNullOrEmpty;

@Data
public class Plant {
    private static final String MONTH_DELIMITER = ";";
    private String name;
    private String link;
    private List<AnnualActivity> activities = new ArrayList<>();

    public Plant(String[] csvRecord) {
        name = csvRecord[0];
        link = csvRecord[1];

        initializeActivity(csvRecord[2], csvRecord[3],
                (startMonth, endMonth) -> new PlantActivity(startMonth, endMonth));
        initializeActivity(csvRecord[4], csvRecord[5],
                (startMonth, endMonth) -> new Prune(startMonth, endMonth, csvRecord[14]));
        initializeActivity(csvRecord[6], csvRecord[7],
                (startMonth, endMonth) -> new TakeCuttings(startMonth, endMonth));
        initializeActivity(csvRecord[8], csvRecord[9],
                (startMonth, endMonth) -> new Divide(startMonth, endMonth));
        initializeActivity(csvRecord[10], csvRecord[11],
                (startMonth, endMonth) -> new Feed(startMonth, endMonth, csvRecord[12], csvRecord[13]));
        initializeActivity(csvRecord[16], csvRecord[17],
                (startMonth, endMonth) -> new OtherActivity(startMonth, endMonth, csvRecord[18]));
        initializeActivity(csvRecord[19], csvRecord[20],
                (startMonth, endMonth) -> new OtherActivity(startMonth, endMonth, csvRecord[21]));
        if (!isNullOrEmpty(csvRecord[15]) && isTender(csvRecord[15])) {
            activities.add(new ProtectFromFrost());
        }
    }

    private void initializeActivity(String startMonth, String endMonth, BiFunction<String, String, AnnualActivity> createActivity) {
        if (!isNullOrEmpty(startMonth) && !isNullOrEmpty(endMonth)) {
            if (startMonth.contains(MONTH_DELIMITER)) {
                String[] startMonthsArray = startMonth.split(MONTH_DELIMITER);
                String[] endMonthsArray = startMonth.split(MONTH_DELIMITER);
                for (int i = 0; i < startMonthsArray.length; i++) {
                    AnnualActivity activity = createActivity.apply(startMonthsArray[i], endMonthsArray[i]);
                    activities.add(activity);
                }
            } else {
                AnnualActivity activity = createActivity.apply(startMonth, endMonth);
                activities.add(activity);
            }
        }
    }

    public List<AnnualActivity> getActivities() {
        return activities;
    }

    private boolean isTender(String hardiness) {
        int rating = Integer.parseInt(hardiness.substring(1, 2));
        return rating <= 3;
    }

}
