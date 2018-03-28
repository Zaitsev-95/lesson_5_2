import java.util.Date;

public class Student implements Human {
    private String name;
    private String secondName;
    private Date birthday;

    public Student(String name, String secondName, Date birthday) {
        this.name = name;
        this.secondName = secondName;
        this.birthday = birthday;
    }

    @Override
    public Date birthday() {
        return birthday;
    }
}