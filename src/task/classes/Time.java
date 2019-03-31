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
        if (this.minutes == 0 && this.hours < 10) return "0" + this.hours + ":" + this.minutes + "0";
        if (this.minutes == 0) return this.hours + "" + ":" + this.minutes + "0";
        if (this.hours < 10) return "0" + this.hours + ":" + this.minutes;
        return this.hours + "" + ":" + this.minutes + "";
    }
}
