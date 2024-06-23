import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Race {

    private static final int RACE_DURATION = 24;
    ArrayList<Car> carsList;

    public Race (ArrayList<Car> carsList) {
        this.carsList = carsList;
    }

    private Car findWinner(ArrayList<Car> cars) {

        ArrayList<Integer> distancesList = new ArrayList<>();
        HashMap<Integer, Car> carsMap = new HashMap<>();

        for (Car car : cars) {
            int distanceTraveled = car.speed * RACE_DURATION;
            distancesList.add(distanceTraveled);
            carsMap.put(distanceTraveled, car);
        }

        int maxDistance = Collections.max(distancesList);
        System.out.printf("%nГонка прошла успешно.%nМаксимальная дистанция, преодоленная победителем гонки, составила %d км.%n", maxDistance);
        return carsMap.get(maxDistance);
    }
    
    public void getWinner() {
        System.out.printf("\nПобедитель гонки: '%s'.%n", findWinner(carsList).name);
    }
}
