import java.util.Date;
import java.util.List;

public class Exam {

    private Subject subject;
    private List<Student> students;
    private Date date;
    private Teacher teacher;
    private int limit;


    public Exam(Subject subject, List<Student> students, Date date, Teacher teacher, int maximumStudents) {
        this.subject = subject;
        this.students = students;
        this.date = date;
        this.teacher = teacher;
        this.limit = maximumStudents;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public Date getDate() {
        return date;
    }

    public Subject getSubject() {
        return subject;
    }

    public int getLimit() {
        return limit;
    }

    public List<Student> getStudents() {
        return students;
    }
}
