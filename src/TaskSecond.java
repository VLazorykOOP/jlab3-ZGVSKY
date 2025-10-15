abstract class Triad {
    protected int first;
    protected int second;
    protected int third;

    public Triad(int first, int second, int third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }

    public abstract void increase(); // збільшення на 1
    public abstract void print();    // друк значення

    @Override
    public abstract String toString();

    @Override
    public abstract boolean equals(Object obj);
}



class Date extends Triad {

    public Date(int day, int month, int year) {
        super(day, month, year);
    }

    @Override
    public void increase() {
        // Проста логіка: додаємо 1 до дня, без перевірки календаря
        first++;
        if (first > 31) {
            first = 1;
            second++;
            if (second > 12) {
                second = 1;
                third++;
            }
        }
    }

    @Override
    public void print() {
        System.out.println("Дата: " + toString());
    }

    @Override
    public String toString() {
        return String.format("%02d.%02d.%04d", first, second, third);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Date)) return false;
        Date other = (Date) obj;
        return this.first == other.first &&
                this.second == other.second &&
                this.third == other.third;
    }
}



class Time extends Triad {

    public Time(int hour, int minute, int second) {
        super(hour, minute, second);
    }

    @Override
    public void increase() {
        third++;
        if (third >= 60) {
            third = 0;
            second++;
            if (second >= 60) {
                second = 0;
                first++;
                if (first >= 24) first = 0;
            }
        }
    }

    @Override
    public void print() {
        System.out.println("Час: " + toString());
    }

    @Override
    public String toString() {
        return String.format("%02d:%02d:%02d", first, second, third);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Time)) return false;
        Time other = (Time) obj;
        return this.first == other.first &&
                this.second == other.second &&
                this.third == other.third;
    }
}


public class TaskSecond {
    public static void main(String[] args) {
        // Масив об’єктів типу базового класу
        Triad[] arr = new Triad[2];
        arr[0] = new Date(31, 12, 2024);
        arr[1] = new Time(23, 59, 59);

        System.out.println("=== Початкові значення ===");
        for (Triad t : arr) {
            t.print();
        }

        System.out.println("\n=== Після збільшення на 1 ===");
        for (Triad t : arr) {
            t.increase();
            t.print();
        }

        // Демонстрація equals
        Date d1 = new Date(1, 1, 2025);
        Date d2 = new Date(1, 1, 2025);
        Date d3 = new Date(2, 1, 2025);

        System.out.println("\n=== Перевірка рівності ===");
        System.out.println(d1 + " == " + d2 + " ? " + d1.equals(d2)); // true
        System.out.println(d1 + " == " + d3 + " ? " + d1.equals(d3)); // false

        Time t1 = new Time(0, 0, 0);
        Time t2 = new Time(0, 0, 0);
        Time t3 = new Time(1, 0, 0);
        System.out.println(t1 + " == " + t2 + " ? " + t1.equals(t2)); // true
        System.out.println(t1 + " == " + t3 + " ? " + t1.equals(t3)); // false
    }
}
