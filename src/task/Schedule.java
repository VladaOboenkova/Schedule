package task;

import java.util.*;

public class Schedule {

    private Map<Train, Time> trainDepartureTime = new HashMap<>();

    private Map<Train, List<String>> listOfIntermediateStations = new HashMap<>();

    boolean addNewTrain(Train train, Time time) {
        List<String> intermediateStations = new ArrayList<>();
        trainDepartureTime.put(train, time);
        listOfIntermediateStations.put(train, intermediateStations);
        return trainDepartureTime.containsKey(train) && listOfIntermediateStations.containsKey(train);
    }

    boolean removeTrain(Train train) {
        if (trainDepartureTime.containsKey(train)) {
            trainDepartureTime.remove(train);
            listOfIntermediateStations.remove(train);
        }
        return !trainDepartureTime.containsKey(train) && !listOfIntermediateStations.containsKey(train);
    }

    boolean addIntermediateStation(Train train, String stationName) {
        if (listOfIntermediateStations.containsKey(train)) {
            return listOfIntermediateStations.get(train).add(stationName);
        }
        return false;
    }

    boolean removeIntermediateStation(Train train, String stationName) {
        if (listOfIntermediateStations.containsKey(train)) {
            return listOfIntermediateStations.get(train).remove(stationName);
        }
        return false;
    }

    public Map<Train, List<String>> getListOfIntermediateStations() {
        return listOfIntermediateStations;
    }

    public void setListOfIntermediateStations(Map<Train, List<String>> listOfIntermediateStations) {
        this.listOfIntermediateStations = listOfIntermediateStations;
    }

    public Map<Train, Time> getTrainDepartureTime() {
        return trainDepartureTime;
    }

    public void setTrainDepartureTime(Map<Train, Time> trainDepartureTime) {
        this.trainDepartureTime = trainDepartureTime;
    }

    Train findNearestTrain(Time currentTime, String arrivalStation) { 
        List<Train> sutableKeys = new ArrayList<>();
        for (Map.Entry<Train, List<String>> pair : listOfIntermediateStations.entrySet()) {
            List<String> stations = pair.getValue();
            Train train = pair.getKey();
            if (stations.contains(arrivalStation)) {
                sutableKeys.add(train);
            } else if (train.getEndStation().equals(arrivalStation)) {
                sutableKeys.add(train);
            }
        } // эта часть собирает поезда(ключи) с наличием нужной станции

        Map<Train, Time> sutableTrains = new HashMap<>();
        for (Train sutableTrain : sutableKeys) {
            Time value = trainDepartureTime.get(sutableTrain);
            if (trainDepartureTime.containsKey(sutableTrain) || (value.getHours() >= currentTime.getHours()))
                sutableTrains.put(sutableTrain, value);
        } // эта часть собирает нужные поезда с их временем отправления в отдельную мапу

        int min = Integer.MAX_VALUE;

        /*for (Map.Entry<Train, Time> secondPair : sutableTrains.entrySet()) {
            Time sutableValue = secondPair.getValue();
            int transporter = stringsToMinutes(sutableValue);
            if ((transporter < min) && (transporter >= curTimeSeconds))
                min = stringsToMinutes(sutableValue);
        } // эта часть находит минимальное подходящее время из всех

        String minTimeString = minutesToString(min);
        Train answerTrain = null;
        for (Map.Entry<Train, String> thirdPair : sutableTrains.entrySet()) {
            Train trainKey = thirdPair.getKey();
            String trainValue = thirdPair.getValue();
            if (trainValue.equals(minTimeString))
                answerTrain = trainKey;
        }*/
        return answerTrain;

    }
}



