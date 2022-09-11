package otisliddy.plant.model.activity;

import java.util.List;

public class ActivityOrder {
    private static final List<Class<? extends AnnualActivity>> ACTIVITY_ORDER =
            List.of(ProtectFromFrost.class, Feed.class, OtherActivity.class, Prune.class, TakeCuttings.class, Divide.class,
                    PlantActivity.class);

    public static int compare(Class<? extends AnnualActivity> firstClass, Class<? extends AnnualActivity> secondClass) {
        return ACTIVITY_ORDER.indexOf(firstClass) - ACTIVITY_ORDER.indexOf(secondClass);
    }
}
