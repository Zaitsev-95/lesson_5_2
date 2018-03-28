import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
public class StudentsRegistry implements ProduceStudent, MiddleAge {
    int quantityStudent;
    Student[] student;
    private Scanner scanner = new Scanner(System.in);
    @Override
    public Student[] produceStudent() {
        student = new Student[quantityStudent];
        System.out.println("Введите какое колличество студентов вы хотите зарегестрировать: ");
        quantityStudent = scanner.nextInt();
        student = new Student[quantityStudent];
        for (int i = 0; i < quantityStudent; i++) {
            System.out.println("Введите Имя");
            String name = scanner.nextLine();
            scanner.nextLine();//без этой строчки считывание Имени пропускается
            System.out.println("Введите Фамилию");
            String secondName = scanner.nextLine();
            System.out.println("Введите Дату рождения в формате (dd.MM.yyyy)");
            SimpleDateFormat format = new SimpleDateFormat();
            format.applyPattern("dd.MM.yyyy");
            String birthdayString = scanner.nextLine();
            Date birthday = null;
            try {
                birthday = format.parse(birthdayString);
            } catch (ParseException e) {
                System.out.println("Введен неверный формат даты!");
                break;
            }
            student[i] = new Student(name, secondName, birthday);
        }
        return student;
    }
    @Override
    public void middleAge(Student[] student) {
        Date today = new Date();
        int quantityStudents = student.length;
        long currentAge = 0;
        long sumAge = 0;
        for (int i = 0; i < quantityStudents; i++) {
            sumAge += student[i].birthday().getTime();
        }
        long averageAge = sumAge / quantityStudents;
        currentAge = today.getTime() - averageAge;
        int residue = (int) (currentAge / 60000);
        int minutes = residue % 60;
        residue = residue / 60;
        int hours = residue % 24;
        residue = residue / 24;
        int days = residue % 30;
        residue = residue / 30;
        int months = residue % 12;
        int years = residue / 12;
        System.out.printf("Средний возраст: \n лет: %d , месяцев: %d , дней: %d , часов: %d , минут: %d", years, months, days, hours, minutes);
    }
}