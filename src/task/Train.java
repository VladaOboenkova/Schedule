package task;

import java.util.*;

public class Train {

    private String nameOfTrain;

    private String endStation;

    private List<String> listOfStations = new ArrayList<>();

    Train(String name, String endStation){
        this.nameOfTrain = name;
        this.endStation = endStation;
    }

    public String getNameOfTrain() {
        return nameOfTrain;
    }

    public void setNameOfTrain(String nameOfTrain) {
        this.nameOfTrain = nameOfTrain;
    }

    public String getEndStation() {
        return endStation;
    }

    public void setEndStation(String endStation) {
        this.endStation = endStation;
    }

    public List<String> getListOfStations() {
        return listOfStations;
    }

    public void setListOfStations(List<String> listOfStations) {
        this.listOfStations = listOfStations;
    }

    boolean addStation(Train train, String stationName) {
        return listOfStations.add(stationName);
    }

    boolean removeStation(Train train, String stationName) {
        if (listOfStations.contains(stationName)) {
            return listOfStations.remove(stationName);
        }
        return false;
    }

    @Override
    public String toString(){
        return this.getNameOfTrain();
    }

}