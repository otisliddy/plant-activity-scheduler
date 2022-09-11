package otisliddy.plant.model.activity;

public class OtherActivity extends AnnualActivity {
    private String description;

    public OtherActivity(String startMonth, String endMonth, String description) {
        super(startMonth, endMonth);
        this.description = description;
    }

    @Override
    public String toString() {
        return description;
    }
}
