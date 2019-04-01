package task;

import classes.Train;
import org.junit.*;
import java.util.*;

public class TrainTest {

    @Test
    public void addStation() {
        Train train1 = new Train("Sapsan123", "Moscow");

        train1.addStation("A");
        train1.addStation("B");

        List<String> actual = new ArrayList<>();
        actual.add("A");
        actual.add("B");

        Assert.assertEquals(train1.getListOfStations(), actual);
    }

    @Test
    public void removeStation() {

    }
}