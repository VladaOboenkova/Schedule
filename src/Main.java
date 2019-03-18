public class Main {
    public static void main(String[] args){
        Schedule schedule = new Schedule();
        Train train1 = new Train("Sapsan123", "Moscow");
        Train train2 = new Train("Sapsan456", "Novosibirsk");
        Train train3 = new Train("Lastochka", "Okulovka");

        schedule.addNewTrain(train1, "7:05");

        schedule.addNewTrain(train2, "7:40");

        schedule.addNewTrain(train3, "8:15");

        schedule.addIntermediateStation(train1, "Tver");

        schedule.addIntermediateStation(train1, "Novgorod");

        schedule.addIntermediateStation(train1, "Rostov");

        schedule.addIntermediateStation(train2, "Novgorod");

        schedule.addIntermediateStation(train2, "A");

        schedule.addIntermediateStation(train3, "A");

        schedule.addIntermediateStation(train3, "Tver");

        schedule.addIntermediateStation(train3, "J");

        schedule.addIntermediateStation(train3, "Moscow");

        schedule.removeIntermediateStation(train3, "J");

        System.out.println(schedule.findNearestTrain("7:40", "Moscow"));
    }
}
