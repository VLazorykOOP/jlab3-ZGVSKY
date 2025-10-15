import java.util.Scanner;

class Person {
    protected String name;
    protected int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void Show() {
        System.out.println("Ім'я: " + name);
        System.out.println("Вік: " + age);
    }
}

class Student extends Person {
    private String group;
    private int year;

    public Student(String name, int age, String group, int year) {
        super(name, age);
        this.group = group;
        this.year = year;
    }

    @Override
    public void Show() {
        System.out.println("=== Студент ===");
        super.Show();
        System.out.println("Група: " + group);
        System.out.println("Курс: " + year);
    }
}

class Teacher extends Person {
    protected String subject;
    protected int experience;

    public Teacher(String name, int age, String subject, int experience) {
        super(name, age);
        this.subject = subject;
        this.experience = experience;
    }

    @Override
    public void Show() {
        System.out.println("=== Викладач ===");
        super.Show();
        System.out.println("Предмет: " + subject);
        System.out.println("Досвід: " + experience + " років");
    }
}

class HeadOfDepartment extends Teacher {
    private String department;
    private int yearsAsHead;

    public HeadOfDepartment(String name, int age, String subject, int experience, String department, int yearsAsHead) {
        super(name, age, subject, experience);
        this.department = department;
        this.yearsAsHead = yearsAsHead;
    }

    @Override
    public void Show() {
        System.out.println("=== Завідувач кафедри ===");
        super.Show();
        System.out.println("Кафедра: " + department);
        System.out.println("Років на посаді: " + yearsAsHead);
    }
}

public class TaskFirst {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Масив типу суперкласу
        Person[] people = new Person[3];

        // Введення даних
        System.out.println("Введіть дані для студента:");
        System.out.print("Ім'я: ");
        String sName = sc.nextLine();
        System.out.print("Вік: ");
        int sAge = sc.nextInt(); sc.nextLine();
        System.out.print("Група: ");
        String group = sc.nextLine();
        System.out.print("Курс: ");
        int year = sc.nextInt(); sc.nextLine();
        people[0] = new Student(sName, sAge, group, year);

        System.out.println("\nВведіть дані для викладача:");
        System.out.print("Ім'я: ");
        String tName = sc.nextLine();
        System.out.print("Вік: ");
        int tAge = sc.nextInt(); sc.nextLine();
        System.out.print("Предмет: ");
        String subject = sc.nextLine();
        System.out.print("Досвід (років): ");
        int exp = sc.nextInt(); sc.nextLine();
        people[1] = new Teacher(tName, tAge, subject, exp);

        System.out.println("\nВведіть дані для завідувача кафедри:");
        System.out.print("Ім'я: ");
        String hName = sc.nextLine();
        System.out.print("Вік: ");
        int hAge = sc.nextInt(); sc.nextLine();
        System.out.print("Предмет: ");
        String hSubject = sc.nextLine();
        System.out.print("Досвід (років): ");
        int hExp = sc.nextInt(); sc.nextLine();
        System.out.print("Кафедра: ");
        String dep = sc.nextLine();
        System.out.print("Років на посаді: ");
        int yearsHead = sc.nextInt();
        people[2] = new HeadOfDepartment(hName, hAge, hSubject, hExp, dep, yearsHead);

        // Вивід масиву
        System.out.println("\n===== Інформація про всіх осіб =====");
        for (Person p : people) {
            p.Show();
            System.out.println("----------------------");
        }

        sc.close();
    }
}
