package task;

public class Train {

    private String nameOfTrain;

    private String endStation;

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

    @Override
    public String toString(){
        return this.getNameOfTrain();
    }
}