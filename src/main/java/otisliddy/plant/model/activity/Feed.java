package otisliddy.plant.model.activity;

import static otisliddy.plant.StringUtils.isNullOrEmpty;

public class Feed extends AnnualActivity {
    private static final String MULCH = "Mulch";
    private short feedFrequencyWeeks;
    private String food;

    public Feed(String startMonth, String endMonth, String feedFrequencyWeeks, String food) {
        super(startMonth, endMonth);
        if (!isNullOrEmpty(feedFrequencyWeeks)) {
            this.feedFrequencyWeeks = Short.parseShort(feedFrequencyWeeks);
        }
        if (!isNullOrEmpty(food)) {
            this.food = food;
        }
    }

    @Override
    public String toString() {
        if (feedFrequencyWeeks != 0) {
            if (feedFrequencyWeeks == 1){
                return String.format("Feed weekly with %s", food);
            }
            return String.format("Feed every %s weeks with %s", feedFrequencyWeeks, food);
        }
        if (MULCH.equals(food)) {
            return "Mulch";
        }
        return "Feed with " + food;
    }
}
