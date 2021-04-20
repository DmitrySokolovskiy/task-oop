package by.it.academia.entity;

import java.util.Calendar;
import java.util.Random;

public class Train {
    private String roadTarget;
    private int trainNumber;
    private Calendar dispatchDataTime;

    public Train() {
        Random rnd = new Random();
        this.trainNumber = rnd.nextInt(888887) + 111111;
    }

    public String getRoadTarget() {
        return roadTarget;
    }

    public void setRoadTarget(String roadTarget) {
        this.roadTarget = roadTarget;
    }

    public int getTrainNumber() {
        return trainNumber;
    }

    public void setTrainNumber(int trainNumber) {
        this.trainNumber = trainNumber;
    }

    public Calendar getDispatchDataTime() {
        return dispatchDataTime;
    }

    public void setDispatchDataTime(Calendar dispatchDataTime) {
        this.dispatchDataTime = dispatchDataTime;
    }

}
