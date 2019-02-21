import java.util.List;

public class Subject {

    private String name;
    private String subjectId;
    private List<Student> students;
    private String credit;
    private String teacher;
    private String time;


    public Subject(String name, String credit, String subjectId, List<Student> students, String teacher, String lessonTime) {
        this.name = name;
        this.credit = credit;
        this.subjectId = subjectId;
        this.students = students;
        this.time = lessonTime;
    }

    public String getLessonTime() {
        return time;
    }


    public String getTeacher() {
        return teacher;
    }

    public String getCredit() {
        return credit;
    }

    public List<Student> getStudents() {
        return students;
    }

    public String getSubjectId() {
        return subjectId;
    }

    public String getName() {
        return name;
    }

}
