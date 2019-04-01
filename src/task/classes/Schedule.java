package classes;

import java.util.*;

public class Schedule {

    private  Map<Train, Time> trainDepartureTime = new HashMap<>();

    public Map<Train, Time> getTrainDepartureTime() {
        return trainDepartureTime;
    }

    public boolean addNewTrain(Train train, Time time) {
        trainDepartureTime.put(train, time);
        return trainDepartureTime.containsKey(train);
    }

    public boolean removeTrain(Train train) {
        if (trainDepartureTime.containsKey(train))
        trainDepartureTime.remove(train);
        else System.out.println("Заданный поезд отсутствует!");
        return !trainDepartureTime.containsKey(train);
    }

    public Map<Train, Time> findNearestTrain(Time currentTime, String arrivalStation) {
        List<Train> sutableKeys = new ArrayList<>();
        for (Map.Entry<Train, Time> pair : trainDepartureTime.entrySet()){
            Train train = pair.getKey();
            if (train.getListOfStations().contains(arrivalStation))
                sutableKeys.add(train);
            else if (train.getEndStation().equals(arrivalStation))
                sutableKeys.add(train);
        }

        Map<Train, Time> sutableTrains = new HashMap<>();
        for (Train sutableTrain : sutableKeys) {
            Time value = trainDepartureTime.get(sutableTrain);
            if (trainDepartureTime.containsKey(sutableTrain) && value.getHours() >= currentTime.getHours()
                    && value.getMinutes() >= currentTime.getMinutes())
                sutableTrains.put(sutableTrain, value);
            else System.out.println("Нет доступного поезда!");
        } // эта часть собирает нужные поезда с их временем отправления в отдельную мапу

        int minHours = 24;
        int minMinutes = 60;

        for (Map.Entry<Train, Time> secondPair : sutableTrains.entrySet()) {
            Time sutableValue = secondPair.getValue();
            Train train = secondPair.getKey();
            if (sutableValue.getHours() <= minHours)
                minHours = sutableValue.getHours();
            else sutableTrains.remove(train, sutableValue);
            if (sutableValue.getMinutes() <= minMinutes)
                minMinutes = sutableValue.getMinutes();
            else sutableTrains.remove(train, sutableValue);
        } // эта часть находит минимальное время; остаётся массив с одним временем, либо несколько

       /* if (sutableTrains.size() != 1)
            System.out.println("Ошибка данных!");*/
        // оставлю список из нескольких поездов с одинаковыми временами, если вдруг такая ситуация происходит
        // потому что они могут отъезжать с разных путей, но в одно время, поэтому
        // нет смыслового конфликта

        return sutableTrains;
    }
}



