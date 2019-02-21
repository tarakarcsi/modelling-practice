import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.List;

public class Main {



    public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException {
        XMLParser xmlP = new XMLParser();
        /*System.out.println(xmlP.getStudentNames("data/Students.xml"));
        System.out.println(xmlP.getStudentID("data/Students.xml"));
        System.out.println(xmlP.getSubjectNames("data/Subjects.xml"));
        System.out.println(xmlP.getSubjectIDs("data/Subjects.xml"));
        System.out.println(xmlP.getTeachers("data/Subjects.xml"));
        System.out.println(xmlP.getTimes("data/Subjects.xml"));
        System.out.println(xmlP.getCredits("data/Subjects.xml"));*/
        //System.out.println(xmlP.readStudents("data/Students.xml"));


        List<Student> students = xmlP.readStudents("data/Students.xml");
        System.out.println(students);

        School school = new School(students);

    }

}
