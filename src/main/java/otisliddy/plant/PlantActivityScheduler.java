package otisliddy.plant;

import otisliddy.plant.model.Plant;
import otisliddy.plant.model.Task;
import otisliddy.plant.model.activity.AnnualActivity;
import otisliddy.plant.model.activity.PlantActivity;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class PlantActivityScheduler {

    private static final String CSV_DELIMITER = ",";

    private final List<Plant> plants;
    private final List<Task> tasks = new ArrayList<>();

    public PlantActivityScheduler(String plantsCsvPath) throws IOException, URISyntaxException {
        ClassLoader classLoader = getClass().getClassLoader();
        URL resource = classLoader.getResource(plantsCsvPath);
        plants = new BufferedReader(new FileReader(new File(resource.toURI())))
                .lines()
                .skip(1) // skip header
                .map(plantRecord -> new Plant(plantRecord.split("\\" + CSV_DELIMITER, -1)))
                .collect(Collectors.toList());

        for (Plant plant : plants) {
            for (AnnualActivity activity : plant.getActivities()) {
                tasks.add(new Task(plant, activity));
            }
        }
        Collections.sort(tasks);
    }

    public void printCurrentActivities() {
        tasks.stream()
                .filter(task -> task.getActivity().isCurrent())
                .filter(task -> !(task.getActivity() instanceof PlantActivity))
                .forEach(System.out::println);
    }

}
