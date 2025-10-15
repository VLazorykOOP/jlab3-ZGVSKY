// Інтерфейс із необхідними методами
interface BaseTriad {
    void increase();  // збільшити на 1
    void print();     // надрукувати
    String toString();
    boolean equals(Object obj);
}


class TriadDate implements BaseTriad {
    private int day;
    private int month;
    private int year;

    public TriadDate(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    @Override
    public void increase() {
        day++;
        if (day > 31) {
            day = 1;
            month++;
            if (month > 12) {
                month = 1;
                year++;
            }
        }
    }

    @Override
    public void print() {
        System.out.println("Дата: " + toString());
    }

    @Override
    public String toString() {
        return String.format("%02d.%02d.%04d", day, month, year);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof TriadDate)) return false;
        TriadDate other = (TriadDate) obj;
        return this.day == other.day &&
                this.month == other.month &&
                this.year == other.year;
    }
}

class TriadTime implements BaseTriad {
    private int hour;
    private int minute;
    private int second;

    public TriadTime(int hour, int minute, int second) {
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    @Override
    public void increase() {
        second++;
        if (second >= 60) {
            second = 0;
            minute++;
            if (minute >= 60) {
                minute = 0;
                hour++;
                if (hour >= 24) hour = 0;
            }
        }
    }

    @Override
    public void print() {
        System.out.println("Час: " + toString());
    }

    @Override
    public String toString() {
        return String.format("%02d:%02d:%02d", hour, minute, second);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof TriadTime)) return false;
        TriadTime other = (TriadTime) obj;
        return this.hour == other.hour &&
                this.minute == other.minute &&
                this.second == other.second;
    }
}

public class TaskThree {
    public static void main(String[] args) {
        // Масив об’єктів інтерфейсного типу
        BaseTriad[] arr = new BaseTriad[2];
        arr[0] = new TriadDate(31, 12, 2024);
        arr[1] = new TriadTime(23, 59, 59);

        System.out.println("=== Початкові значення ===");
        for (BaseTriad t : arr) t.print();

        System.out.println("\n=== Після збільшення на 1 ===");
        for (BaseTriad t : arr) {
            t.increase();
            t.print();
        }

        System.out.println("\n=== Перевірка рівності ===");
        TriadDate d1 = new TriadDate(1, 1, 2025);
        TriadDate d2 = new TriadDate(1, 1, 2025);
        TriadTime t1 = new TriadTime(0, 0, 0);
        TriadTime t2 = new TriadTime(0, 0, 0);

        System.out.println(d1 + " == " + d2 + " ? " + d1.equals(d2));
        System.out.println(t1 + " == " + t2 + " ? " + t1.equals(t2));
    }
}

