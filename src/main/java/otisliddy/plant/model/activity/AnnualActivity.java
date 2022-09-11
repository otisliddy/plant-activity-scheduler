package otisliddy.plant.model.activity;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.Month;
import java.util.Arrays;
import java.util.Calendar;

import static otisliddy.plant.StringUtils.equalsThreeLetterMonth;

@Getter
@NoArgsConstructor
public class AnnualActivity {
    protected Month startMonth;
    protected Month endMonth;

    public AnnualActivity(String startMonth, String endMonth) {
        this.startMonth = getMonthFromString(startMonth);
        this.endMonth = getMonthFromString(endMonth);
    }

    private Month getMonthFromString(String monthString) {
        return Arrays.stream(Month.values())
                .filter(month -> equalsThreeLetterMonth(month, monthString))
                .findFirst()
                .get();
    }

    public boolean isCurrent() {
        int currentMonth = Calendar.getInstance().get(Calendar.MONTH);
        if (startMonth.ordinal() <= endMonth.ordinal()) {
            return currentMonth >= startMonth.ordinal() && currentMonth <= endMonth.ordinal();
        }
        return currentMonth >= startMonth.ordinal() || currentMonth <= endMonth.ordinal();
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }
}
