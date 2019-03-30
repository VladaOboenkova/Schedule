package task;

public class Main {
    public static void main(String[] args){

        Schedule schedule = new Schedule();

        Train train1 = new Train("Sapsan123", "Moscow");
        Train train2 = new Train("Sapsan456", "Novosibirsk");
        Train train3 = new Train("Lastochka", "Okulovka");

        Time time1 = new Time(7, 40);
        Time time2 = new Time(8, 30);
        Time time3 = new Time(8, 10);

        schedule.addNewTrain(train1, time1);
        System.out.println(schedule.getTrainDepartureTime());

        schedule.addNewTrain(train2, time2);
        System.out.println(schedule.getTrainDepartureTime());

        schedule.addNewTrain(train3, time3);
        System.out.println(schedule.getTrainDepartureTime());

        System.out.println(schedule.addIntermediateStation(train1, "A"));
    }
}
