package otisliddy.plant.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import otisliddy.plant.model.activity.ActivityOrder;
import otisliddy.plant.model.activity.AnnualActivity;

import static otisliddy.plant.StringUtils.toThreeLetterMonth;

@Data
@AllArgsConstructor
public class Task implements Comparable {
    private Plant plant;
    private AnnualActivity activity;

    @Override
    public int compareTo(Object other) {
        if (other == null) {
            return -1;
        }
        Task otherPlantActivity = (Task) other;
        if (this.activity.getClass() != otherPlantActivity.activity.getClass()) {
            return ActivityOrder.compare(this.activity.getClass(), otherPlantActivity.activity.getClass());
        }
        return this.plant.getName().compareTo(otherPlantActivity.plant.getName());
    }

    @Override
    public String toString() {
        return String.format("[%s - %s] %s: %s", toThreeLetterMonth(activity.getStartMonth()), toThreeLetterMonth(activity.getEndMonth()),
                plant.getName(), activity.toString());
    }
}
