package otisliddy.plant.model.activity;

import static otisliddy.plant.StringUtils.isNullOrEmpty;

public class Prune extends AnnualActivity {
    private String pruningGroup;

    public Prune(String startMonth, String endMonth, String pruningGroup) {
        super(startMonth, endMonth);
        if (!isNullOrEmpty(pruningGroup)) {
            this.pruningGroup = pruningGroup;
        }
    }

    @Override
    public String toString() {
        return "Prune - " + pruningGroup;
    }
}
