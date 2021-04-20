package by.it.academia;

import by.it.academia.entity.Depo;
import by.it.academia.entity.Train;
import by.it.academia.presentation.DepoView;

import java.util.Calendar;

public class Main {
    public static void main(String[] args) {
        Depo depo = new Depo();
        Train train = new Train();
        Train train1 = new Train();
        Train train2 = new Train();
        Train train3 = new Train();
        Train train4 = new Train();
        Train train5 = new Train();
        Train train6 = new Train();


        Calendar calendar = Depo.dateFormatter(2021, 01, 03, 20, 12, 10);
        Calendar calendar1 = Depo.dateFormatter(2021, 12, 03, 23, 12, 10);
        Calendar calendar2 = Depo.dateFormatter(2021, 04, 07, 10, 14, 10);
        Calendar calendar3 = Depo.dateFormatter(2021, 04, 07, 10, 14, 10);


        depo.addTrainToDepo(train, "Москва центральный вокзал", calendar1);
        depo.addTrainToDepo(train6, "Анапа почти центральный вокзал", calendar3);
        depo.addTrainToDepo(train1, "Варшава центральный вокзал", calendar2);
        depo.addTrainToDepo(train2, "Ньюйорк центральный вокзал", calendar);
        depo.addTrainToDepo(train3, "Нарильск центральный вокзал", calendar3);
        depo.addTrainToDepo(train4, "Ньюйорк центральный вокзал", calendar1);
        depo.addTrainToDepo(train5, "Анапа почти центральный вокзал", calendar1);

//        Тут вызываем сортировку через comparator
        DepoView.depoPrinter(depo);
        DepoView.depoPrinterRouteTarget(depo);
        DepoView.depoPrinterTrainNumber(depo, 867439);

        //Сортировка по маршруту и при дублировании по дате
        DepoView.depoHandPrinterRouteTarget(depo);
        //Сортировка по номеру поезда
        DepoView.depoHandPrinterNumber(depo);
    }
}
