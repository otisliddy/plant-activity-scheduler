package otisliddy.plant;

import java.io.IOException;
import java.net.URISyntaxException;

public class Main {

    public static void main(String[] args) throws IOException, URISyntaxException {
        PlantActivityScheduler pas = new PlantActivityScheduler("plants.csv");
        pas.printCurrentActivities();
    }
}
