package classes;

public class Time {

    private int hours;

    private int minutes;

    public Time(int hours, int minutes) {
        if (hours > 23 || hours < 0)
            System.out.println("Ошибка ввода!");
        else this.hours = hours;
        if (minutes > 59 || minutes < 0)
            System.out.println("Ошибка ввода!");
        else this.minutes = minutes;
    }

    int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        if (hours > 23 || hours < 0)
            System.out.println("Ошибка ввода!");
        else this.hours = hours;
    }

    int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        if (minutes > 59 || minutes < 0)
            System.out.println("Ошибка ввода!");
        else this.minutes = minutes;
    }

    @Override
    public String toString(){
        return this.hours + "" + ":" + this.minutes + "";
    }
}
