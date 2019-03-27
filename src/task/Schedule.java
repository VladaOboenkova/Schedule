package task;

import java.util.*;

public class Schedule {

    private Map<Train, String> trainDepartureTime;

    private Map<Train, List<String>> listOfIntermediateStations;

    Schedule(Map<Train, String> trainDepartureTime, Map<Train, List<String>> listOfIntermediateStations){
        this.trainDepartureTime = trainDepartureTime;
        this.listOfIntermediateStations = listOfIntermediateStations;
    }
    
    void addNewTrain(Train train, String time) {
        ArrayList<String> intermediateStations = new ArrayList<>();
        trainDepartureTime.put(train, time);
        listOfIntermediateStations.put(train, intermediateStations);
    }

    // System.current - time, byte
    // boolean
    public void removeTrain(Train train) {
        if (trainDepartureTime.containsKey(train)) {
            trainDepartureTime.remove(train);
            listOfIntermediateStations.remove(train);
        }
    }

    void addIntermediateStation(Train train, String stationName) {
        if (listOfIntermediateStations.containsKey(train)) {
            List<String> intermediateStations = listOfIntermediateStations.get(train);
            intermediateStations.add(stationName);
            listOfIntermediateStations.put(train, intermediateStations);
        }
    }

    void removeIntermediateStation(Train train, String stationName) {
        if (listOfIntermediateStations.containsKey(train)) {
            List<String> intermediateStations = listOfIntermediateStations.get(train);
            intermediateStations.remove(stationName);
            listOfIntermediateStations.put(train, intermediateStations);
        }
    }

    private int stringsToMinutes(String time) {
        String[] timeParts = time.split(":");
        int hours = Integer.parseInt(timeParts[0]);
        int hoursToMinutes = hours * 60;
        int minutes = Integer.parseInt(timeParts[1]);
        return hoursToMinutes + minutes;
    }

    private String minutesToString(int minutes) {
        int hours = minutes / 60;
        int newMinutes = minutes - hours * 60;
        String hoursToString = Integer.toString(hours);
        String minutesToString = Integer.toString(newMinutes);
        return String.join(":", hoursToString, minutesToString);
    }

    public Map<Train, List<String>> getListOfIntermediateStations() {
        return listOfIntermediateStations;
    }

    public void setListOfIntermediateStations(Map<Train, List<String>> listOfIntermediateStations) {
        this.listOfIntermediateStations = listOfIntermediateStations;
    }

    public Map<Train, String> getTrainDepartureTime() {
        return trainDepartureTime;
    }

    public void setTrainDepartureTime(Map<Train, String> trainDepartureTime) {
        this.trainDepartureTime = trainDepartureTime;
    }

    /*Train findNearestTrain(String currentTime, String arrivalStation) { // не void, а Train!!!
        List<Train> sutableKeys = new ArrayList<>();
        for (Map.Entry<Train, List<String>> pair : listOfIntermediateStations.entrySet()) {
            List<String> stations = pair.getValue();
            Train train = pair.getKey();
            if (stations.contains(arrivalStation)) {
                sutableKeys.add(train);
            } else if (train.endStation.equals(arrivalStation)) {
                sutableKeys.add(train);
            }
        } // эта часть собирает поезда(ключи) с наличием нужной станции

        Map<Train, String> sutableTrains = new HashMap<>();
        for (Train sutableTrain : sutableKeys) {
            String value = trainDepartureTime.get(sutableTrain);
            if (trainDepartureTime.containsKey(sutableTrain))
                sutableTrains.put(sutableTrain, value);
        } // эта часть собирает нужные поезда с их временем отправления в отдельную мапу

        int curTimeSeconds = stringsToMinutes(currentTime);
        int min = Integer.MAX_VALUE;

        for (Map.Entry<Train, String> secondPair : sutableTrains.entrySet()) {
            String sutableValue = secondPair.getValue();
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
        }
        return answerTrain;*/
    }



