package racingGame.domain;

public class Car {

    CarName carName;
    CarDist carDist;

    public Car(CarName carName, CarDist carDist) {
        this.carName = carName;
        this.carDist = carDist;
    }

    public void move(CarMoveStrategy carMoveStrategy) {
        if (isMovable(carMoveStrategy)) {
            carDist.stepForward();
        }
    }

    private static boolean isMovable(CarMoveStrategy carMoveStrategy) {
        return carMoveStrategy.isMovable();
    }

    public String getCarName() {
        return carName.getCarName();
    }

    public int getCarDist() {
        return carDist.getCarDist();
    }


}
