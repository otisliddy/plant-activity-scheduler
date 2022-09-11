package otisliddy.plant.model.activity;

public class PlantActivity extends AnnualActivity {
    public PlantActivity(String startMonth, String endMonth) {
        super(startMonth, endMonth);
    }

    @Override
    public String toString() {
        return "Plant out";
    }
}
