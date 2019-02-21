import java.util.List;

public class Teacher {

    private String name;
    private List<String> subjects;

    public Teacher(String name, List<String> subjects) {
        this.name = name;
        this.subjects = subjects;
    }

    public List<String> getSubjects() {
        return subjects;
    }

    public String getName() {
        return name;
    }
}
