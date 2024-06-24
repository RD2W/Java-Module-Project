import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println("Добро пожаловать на автогонки!\nДля проведения гонок нужно три автомобиля.");

        ArrayList<Car> carsList = new ArrayList<>();

        for (int carNumber = 1; carNumber <= NUMBER_OF_CARS; carNumber++) {

            System.out.println("\nОпишите параметры автомобиля №" + carNumber);

            nameCar = setName();
            speedCar = setSpeed();
            carsList.add(new Car(nameCar, speedCar));
        }

        System.out.println("\nСписок автомобилелей участвующих в гонке:");
        for (Car car : carsList) {
            System.out.printf("\n - '%s', может разгоняться до %d км/ч.%n", car.name, car.speed);
        }

        System.out.println("\nНа старт, внимание, марш!");
        Race carRace = new Race(carsList);
        carRace.getWinner();
    }

    private static final int NUMBER_OF_CARS = 3, MIN_SPEED = 1, MAX_SPEED = 250;
    static int speedCar;
    static String nameCar;

    private static String setName() {
        Scanner scannerName = new Scanner(System.in);
        String inputName;

        do {
            System.out.println("Введите имя автомобиля:");
            inputName = scannerName.next().trim().toLowerCase();

            if (inputName.isBlank() || inputName.isEmpty()) {
                System.out.println("Введено не корректное имя автомобиля!");
            }

        } while (inputName.isBlank() || inputName.isEmpty());

        return inputName;
    }

    private static int setSpeed() {
        Scanner scannerSpeed = new Scanner(System.in);
        int inputSpeed;

        do {
            System.out.printf("Укажите максимально развиваемую скорость, введите число в пределах от %d до %d:%n", MIN_SPEED, MAX_SPEED);
            inputSpeed = scannerSpeed.nextInt();

            if (!((inputSpeed >= MIN_SPEED) && (inputSpeed <= MAX_SPEED))) {
                System.out.println("\nВведено недопустимое значение максимальной скорости автомобиля!");
            }
        } while (!((inputSpeed >= MIN_SPEED) && (inputSpeed <= MAX_SPEED)));

        return inputSpeed;
    }
}
