package classes;

public class Time {

    private int hours;

    private int minutes;

    public Time(int hours, int minutes) {
        this.hours = hours;
        this.minutes = minutes;
    }

    int getHours() {
        return hours;
    }

    public void setHours(byte hours) {
        if (hours > 23 || hours < 0)
            System.out.println("Ошибка ввода!");
        this.hours = hours;
    }

    int getMinutes() {
        return minutes;
    }

    public void setMinutes(byte minutes) {
        if (minutes > 59 || minutes < 0)
            System.out.println("Ошибка ввода!");
        this.minutes = minutes;
    }

    @Override
    public String toString(){
        return this.hours + "" + ":" + this.minutes + "";
    }
}