package by.it.academia.entity;

import java.util.ArrayList;

public class DepoLogic {
    public static ArrayList<Train> handmadeSort(Depo depo) {
        ArrayList<Train> sortedTrains = new ArrayList<>();
        ArrayList<Train> trains = depo.getTrains();
        for (Train train : trains) {
            System.out.println(train.getTrainNumber() + "  " + train.getDispatchDataTime().getTime());
        }
        for (int i = 0; i < trains.size(); i++) {
        }
        return sortedTrains;
    }

    public static ArrayList<Train> swap(ArrayList<Train> trains, int oneIndex, int twoIndex) {
        Train temp = trains.get(oneIndex);
        trains.set(oneIndex, trains.get(twoIndex));
        trains.set(twoIndex, temp);
        return trains;
    }


    static void heapify(ArrayList<Train> trains, int length, int i) {
        int leftChild = 2 * i + 1;
        int rightChild = 2 * i + 2;
        int largest = i;

        // если левый дочерний больше родительского
        if (leftChild < length && trains.get(leftChild).getTrainNumber() > trains.get(largest).getTrainNumber()) {
            largest = leftChild;
        }

        // если правый дочерний больше родительского
        if (rightChild < length && trains.get(rightChild).getTrainNumber() > trains.get(largest).getTrainNumber()) {
            largest = rightChild;
        }

        // если должна произойти замена
        if (largest != i) {
            swap(trains, i, largest);
            heapify(trains, length, largest);
        }
    }

    static ArrayList<Train> heapify(ArrayList<Train> trains, int length, int i, boolean roadFilter) {
        int leftChild = 2 * i + 1;
        int rightChild = 2 * i + 2;
        int largest = i;

        char leftElement = trains.get(leftChild).getRoadTarget().charAt(0);
        char rightElement = trains.get(rightChild).getRoadTarget().charAt(0);
        char largestElement = trains.get(largest).getRoadTarget().charAt(0);


        // если левый дочерний больше родительского
        if (leftChild < length && leftElement > largestElement) {
            largest = leftChild;
        }

        // если правый дочерний больше родительского
        if (rightChild < length && rightElement > largestElement) {
            largest = rightChild;
        }

        // если должна произойти замена
        if (largest != i) {
            swap(trains, i, largest);
            heapify(trains, length, largest);
        }
        return trains;
    }

    public static ArrayList<Train> heapSort(ArrayList<Train> trains, boolean roadFilter) {
        if (trains.size() == 0) return trains;

        // Строим кучу
        int length = trains.size();

        if (!roadFilter) {
            // проходим от первого без ответвлений к корню
            for (int i = length / 2 - 1; i >= 0; i--)
                heapify(trains, length, i);

            for (int i = length - 1; i >= 0; i--) {
                swap(trains, 0, i);

                heapify(trains, i, 0);
            }
        } else {
            for (int i = 0; i < trains.size(); i++) {
                char[] charRootRoad = trains.get(i).getRoadTarget().toCharArray();
                for (int j = 0; j < trains.size(); j++) {
                    if (trains.get(i).getRoadTarget().compareTo(trains.get(j).getRoadTarget()) != 0) {
                        char[] charRoad = trains.get(j).getRoadTarget().toCharArray();
                        if (charRootRoad[0] != charRoad[0]) {
                            if (!(charRootRoad[0] > charRoad[0])) {
                                swap(trains, i, j);
                            }
                        } else {
                            //Сравниваем по символам в строке точки отправления пока не найдём отличия, если находим, то меняем и переходим к следующему поезду
                            int ksize = charRootRoad.length < charRoad.length ? charRootRoad.length : charRoad.length;
                            for (int k = 1; k < ksize; k++) {
                                if (charRootRoad[k] > charRoad[k]) {
                                    swap(trains, i, j);
                                    break;
                                }
                            }
                        }
                    } else {
                        if (trains.get(i).getDispatchDataTime().compareTo(trains.get(j).getDispatchDataTime()) != 0) {
                            if (trains.get(i).getDispatchDataTime().before(trains.get(j).getDispatchDataTime())) {
                                swap(trains, i, j);
                            }
                        }
                    }
                }
            }
        }
        return trains;
    }
}
