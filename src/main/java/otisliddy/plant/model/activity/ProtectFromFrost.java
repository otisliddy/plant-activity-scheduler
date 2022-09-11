package otisliddy.plant.model.activity;

import java.time.Month;

public class ProtectFromFrost extends AnnualActivity {
    public ProtectFromFrost() {
        this.startMonth = Month.OCTOBER;
        this.endMonth = Month.NOVEMBER;
    }

    @Override
    public String toString() {
        return "Protect from frost";
    }
}
