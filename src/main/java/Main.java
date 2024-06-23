import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println("Добро пожаловать на автогонки!\nДля проведения гонок нужно три автомобиля.");

        ArrayList<Car> carsList = new ArrayList<>();

        for (int i = 1; i <= numberOfCars; i++) {
            int carNumber = i;
            System.out.println("\nОпишите параметры автомобиля №" + carNumber);

            nameCar = setName();
            speedCar = setSpeed();
            carsList.add(new Car(nameCar, speedCar));
        }

        System.out.println("\nСписок автомобилелей участвующих в гонке:");
        for (Car car : carsList) {
            System.out.println("\n - '" + car.name + "', может разгоняться до " + car.speed + " км/ч.");
        }

    }

    private static final int MIN_SPEED = 1, MAX_SPEED = 250;
    static int numberOfCars = 3, speedCar = 0;
    static String nameCar;

    private static String setName() {
        Scanner scannerName = new Scanner(System.in);
        String inputName;

        do {
            System.out.println("Введите имя автомобиля:");
            inputName = scannerName.nextLine().trim().toLowerCase();

            if (inputName.isBlank() || inputName.isEmpty()) {
                System.out.println("Введено не корректное имя автомобиля!");
            }

        } while (inputName.isBlank() || inputName.isEmpty());

        return inputName;
    }

    private static int setSpeed() {
        Scanner scannerSpeed = new Scanner(System.in);
        int inputSpeed = 0;

        while (!((inputSpeed >= MIN_SPEED) && (inputSpeed <= MAX_SPEED))) {

            System.out.println("Укажите максимально развиваемую скорость, введите число в пределах от 1 до 250:");
            inputSpeed = scannerSpeed.nextInt();

            if (!((inputSpeed >= MIN_SPEED) && (inputSpeed <= MAX_SPEED))) {
                System.out.println("Введено недопустимое значение максимальной скорости автомобиля!");
            }
        }

        return inputSpeed;
    }

}
