import java.util.List;

public class School {

    private List<Student> students;


    private List<Subject> subjects;

    public School(List<Student> students) {
        this.students = students;
    }

    public List<Student> getStudents() {
        return students;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    //public Student getStudentById(String id) {

    //}

}
