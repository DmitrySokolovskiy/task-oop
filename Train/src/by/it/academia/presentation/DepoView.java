package by.it.academia.presentation;

import by.it.academia.entity.Depo;
import by.it.academia.entity.DepoLogic;
import by.it.academia.entity.Train;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Comparator;

public class DepoView {
    public static void depoPrinter(Depo depo) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        System.out.println("сортировка по времени отправки");
        System.out.println("Поезд:          Дата:              Точка назначения:");
        Collections.sort(depo.getTrains(), Comparator.comparing(Train::getDispatchDataTime));
        for (Train tr : depo.getTrains()) {
            System.out.printf("%s | %s | %s\n", tr.getTrainNumber(), df.format(tr.getDispatchDataTime().getTime()), tr.getRoadTarget());
        }

    }

    public static void depoPrinterRouteTarget(Depo depo) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        System.out.println("сортировка по месту доставки");
        System.out.println("Поезд:          Дата:              Точка назначения:");
        Collections.sort(depo.getTrains(), Comparator.comparing(Train::getRoadTarget));
        for (Train tr : depo.getTrains()) {
            System.out.printf("%s | %s | %s\n", tr.getTrainNumber(), df.format(tr.getDispatchDataTime().getTime()), tr.getRoadTarget());
        }
    }

    public static void depoPrinterTrainNumber(Depo depo, int trainNumber) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        for (Train tr: depo.getTrains()) {
            //tr.setTrainNumber(trainNumber);
            if(tr.getTrainNumber() == trainNumber){
                System.out.printf("По номеру %s был найден поезд:\n", trainNumber);
                System.out.println("Поезд:          Дата:              Точка назначения:");
                System.out.printf("%s | %s | %s\n", tr.getTrainNumber(), df.format(tr.getDispatchDataTime().getTime()), tr.getRoadTarget());
            }
        }
    }

    public static void depoHandPrinterRouteTarget(Depo depo) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        System.out.println("Ручная сортировка по месту доставки");
        for (Train tr : DepoLogic.heapSort(depo.getTrains(), true)) {
            System.out.printf("%s | %s | %s\n", tr.getTrainNumber(), df.format(tr.getDispatchDataTime().getTime()), tr.getRoadTarget());
        }
    }

    public static void depoHandPrinterNumber(Depo depo) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        System.out.println("Ручная сортировка по номеру поезда");
        for (Train tr : DepoLogic.heapSort(depo.getTrains(), false)) {
            System.out.printf("%s | %s | %s\n", tr.getTrainNumber(), df.format(tr.getDispatchDataTime().getTime()), tr.getRoadTarget());
        }

    }
}
