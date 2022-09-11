package otisliddy.plant.model.activity;

public class TakeCuttings extends AnnualActivity {
    public TakeCuttings(String startMonth, String endMonth) {
        super(startMonth, endMonth);
    }

    @Override
    public String toString() {
        return "Take cuttings";
    }
}
