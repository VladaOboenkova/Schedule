package task;

import classes.Schedule;
import classes.Time;
import classes.Train;
import org.junit.*;
import java.util.*;

public class ScheduleTest {

    @Test
    public void addNewTrain() {

        Schedule schedule = new Schedule();

        Train train1 = new Train("Sapsan123", "Moscow");
        Train train2 = new Train("Sapsan456", "Novosibirsk");
        Train train3 = new Train("Lastochka", "Okulovka");

        Time time1 = new Time(7, 40);
        Time time2 = new Time(8, 30);
        Time time3 = new Time(8, 10);

        schedule.addNewTrain(train1, time1);
        schedule.addNewTrain(train2, time2);
        schedule.addNewTrain(train3, time3);

        Map<Train, Time> actual = new HashMap<>();
        actual.put(train1, time1);
        actual.put(train2, time2);
        actual.put(train3, time3);

        Assert.assertEquals(schedule.getTrainDepartureTime(), actual);
    }

    @Test
    public void removeTrain() {

        Schedule schedule = new Schedule();

        Train train1 = new Train("Sapsan123", "Moscow");
        Train train2 = new Train("Sapsan456", "Novosibirsk");
        Train train3 = new Train("Lastochka", "Okulovka");

        Time time1 = new Time(7, 40);
        Time time2 = new Time(8, 30);
        Time time3 = new Time(8, 10);

        schedule.addNewTrain(train1, time1);
        schedule.addNewTrain(train2, time2);
        schedule.addNewTrain(train3, time3);

        schedule.removeTrain(train1);

        Map<Train, Time> actual = new HashMap<>();
        actual.put(train2, time2);
        actual.put(train3, time3);

        Assert.assertEquals(schedule.getTrainDepartureTime(), actual);
    }

    @Test
    public void findNearestTrain() {
        Schedule schedule = new Schedule();

        Train train1 = new Train("Sapsan123", "Moscow");
        Train train2 = new Train("Sapsan456", "Novosibirsk");
        Train train3 = new Train("Lastochka", "Okulovka");

        Time time1 = new Time(7, 40);
        Time time2 = new Time(8, 30);
        Time time3 = new Time(8, 10);

        Time currentTime = new Time(7, 30);

        schedule.addNewTrain(train1, time1);
        schedule.addNewTrain(train2, time2);
        schedule.addNewTrain(train3, time3);

        Map<Train, Time> expected = schedule.findNearestTrain(currentTime, "Moscow");

        Map<Train, Time> actual = new HashMap<>();
        actual.put(train1, time1);

        Assert.assertEquals(expected, actual);

        train2.addStation("Moscow");
        Assert.assertEquals(expected, actual);
    }
}