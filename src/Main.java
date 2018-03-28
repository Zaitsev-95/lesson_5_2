public class Main {

    public static void main(String[] args) {
        StudentsRegistry studentsRegistry = new StudentsRegistry();
        Student[] students = studentsRegistry.produceStudent();
        studentsRegistry.middleAge(students);
        studentsRegistry.produceStudent();
    }
}