package by.it.academia.entity;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Depo {
    private ArrayList<Train> trains;

    public Depo() {
        this.trains = new ArrayList<>();
    }

    public void addTrainToDepo(Train train, String route, Calendar dateTimeDispatch) {
        for (int i =0; i < trains.size(); i++) {
            if (trains.get(i).getTrainNumber() == train.getTrainNumber()) {
                train.setRoadTarget(route);
                train.setDispatchDataTime(dateTimeDispatch);
                trains.set(i, train);
                return;
            }
        }
        train.setRoadTarget(route);
        train.setDispatchDataTime(dateTimeDispatch);
        trains.add(train);
    }

    public static Calendar dateFormatter(int year, int month, int day, int hour, int minute, int second) {
        Calendar calendar = new GregorianCalendar(year, month -1, day);
        calendar.set(Calendar.HOUR, hour);
        calendar.set(Calendar.MINUTE, minute);
        calendar.set(Calendar.SECOND, second);

        return calendar;
    }

    public ArrayList<Train> getTrains() {
        return trains;
    }
}
