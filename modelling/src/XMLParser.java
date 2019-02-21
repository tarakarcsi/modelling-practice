import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class XMLParser {

    public Student getStudentById(List<Student> students, String id) {
        Student student = new Student();

        for(int i = 0; i < students.size(); i++) {
            if(students.get(i).getStudentId().equals(id)) {
                student = students.get(i);
            }
        }
        return student;
    }

    public List<Student> readStudents(String xmlPath) throws ParserConfigurationException, IOException, SAXException { /* parsing the Students.xml file*/
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc = db.parse(new File(xmlPath));
        doc.getDocumentElement().normalize();
        List<Student> result = new ArrayList<>();


        NodeList studentNode = doc.getElementsByTagName("Student");

        for (int i = 0; i < studentNode.getLength(); i++) {
            Node studentNodes = studentNode.item(i);

            if (studentNodes.getNodeType() == Node.ELEMENT_NODE) {
                Element firstStudentElement = (Element) studentNodes;

                String name = (firstStudentElement.getAttribute("name"));
                String id = (firstStudentElement.getAttribute("id"));

                Student stud = new Student(name, id);
                result.add(stud);
            }
        }
        return result;
    }

    public List<Subject> getSubjects(String xmlPath) throws IOException, SAXException, ParserConfigurationException {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc = db.parse(new File(xmlPath));
        doc.getDocumentElement().normalize();
        List<Subject> result = new ArrayList<>();

        NodeList subjectNode = doc.getElementsByTagName("Subject");

        for (int i = 0; i < subjectNode.getLength(); i++) {
            Node subjectNodes = subjectNode.item(i);

            if (subjectNodes.getNodeType() == Node.ELEMENT_NODE) {
                Element firstSubjectElement = (Element)subjectNodes;

                NodeList nameList = firstSubjectElement.getElementsByTagName("name");
                String name = nameList.item(0).getTextContent();

                NodeList idList = firstSubjectElement.getElementsByTagName("id");
                String id = idList.item(0).getTextContent();

                NodeList teacherList = firstSubjectElement.getElementsByTagName("teacher");
                String teacher = teacherList.item(0).getTextContent();

                NodeList timeList = firstSubjectElement.getElementsByTagName("time");
                String time = timeList.item(0).getTextContent();

                NodeList creditList = firstSubjectElement.getElementsByTagName("credit");
                String credit = creditList.item(0).getTextContent();

                NodeList sIdList = firstSubjectElement.getElementsByTagName("studentIds");
                List<Student> students = new ArrayList<>();
                for (int j = 0; j < sIdList.getLength(); j++) {
                    Node sIdNode = sIdList.item(j);
                    if(sIdNode.getNodeType() == Node.ELEMENT_NODE) {
                        Element idElement = (Element) sIdNode;

                        NodeList studIdList = idElement.getElementsByTagName("studentId");
                        students.add(getStudentById(readStudents(xmlPath), getStudentById()).getTextContent());
                    }
                }

                Subject subj = new Subject(name, credit, id, students, teacher, time);
                result.add(subj);
            }
        }


        return result;
    }

    /*public List<String> getStudentID(String xmlPath) throws ParserConfigurationException, IOException, SAXException {

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc = db.parse(new File(xmlPath));
        doc.getDocumentElement().normalize();
        List<String> result = new ArrayList<>();


        NodeList studentNode = doc.getElementsByTagName("Student");

        for (int i = 0; i < studentNode.getLength(); i++) {
            Node studentNodes = studentNode.item(i);

            if (studentNodes.getNodeType() == Node.ELEMENT_NODE) {
                Element firstStudentElement = (Element) studentNodes;
            }
        }
        return result;
    }*/

    public List<String> getSubjectNames(String xmlPath) throws ParserConfigurationException, IOException, SAXException {

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc = db.parse(new File(xmlPath));
        doc.getDocumentElement().normalize();

        List<String> result = new ArrayList<>();

        NodeList subjectNode = doc.getElementsByTagName("Subject");
        int count = subjectNode.getLength();

        for (int i = 0; i < subjectNode.getLength(); i++) {
            Node subjectNodes = subjectNode.item(i);

            if (subjectNodes.getNodeType() == Node.ELEMENT_NODE) {
                Element firstSubjectElement = (Element)subjectNodes;

                NodeList nameList = firstSubjectElement.getElementsByTagName("name");
                result.add(nameList.item(0).getTextContent());
            }
        }

        return result;
    }

    public List<String> getSubjectIDs(String xmlPath) throws ParserConfigurationException, IOException, SAXException {

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc = db.parse(new File(xmlPath));
        doc.getDocumentElement().normalize();

        List<String> result = new ArrayList<>();

        NodeList subjectNode = doc.getElementsByTagName("Subject");
        int count = subjectNode.getLength();

        for (int i = 0; i < subjectNode.getLength(); i++) {
            Node subjectNodes = subjectNode.item(i);

            if (subjectNodes.getNodeType() == Node.ELEMENT_NODE) {
                Element firstSubjectElement = (Element)subjectNodes;

                NodeList nameList = firstSubjectElement.getElementsByTagName("id");
                result.add(nameList.item(0).getTextContent());
            }
        }

        return result;
    }
    public List<String> getTeachers(String xmlPath) throws ParserConfigurationException, IOException, SAXException {

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc = db.parse(new File(xmlPath));
        doc.getDocumentElement().normalize();

        List<String> result = new ArrayList<>();

        NodeList subjectNode = doc.getElementsByTagName("Subject");
        int count = subjectNode.getLength();

        for (int i = 0; i < subjectNode.getLength(); i++) {
            Node subjectNodes = subjectNode.item(i);

            if (subjectNodes.getNodeType() == Node.ELEMENT_NODE) {
                Element firstSubjectElement = (Element)subjectNodes;

                NodeList nameList = firstSubjectElement.getElementsByTagName("teacher");
                result.add(nameList.item(0).getTextContent());
            }
        }

        return result;
    }

    public List<String> getTimes(String xmlPath) throws ParserConfigurationException, IOException, SAXException {

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc = db.parse(new File(xmlPath));
        doc.getDocumentElement().normalize();

        List<String> result = new ArrayList<>();

        NodeList subjectNode = doc.getElementsByTagName("Subject");
        int count = subjectNode.getLength();

        for (int i = 0; i < subjectNode.getLength(); i++) {
            Node subjectNodes = subjectNode.item(i);

            if (subjectNodes.getNodeType() == Node.ELEMENT_NODE) {
                Element firstSubjectElement = (Element)subjectNodes;

                NodeList nameList = firstSubjectElement.getElementsByTagName("time");
                result.add(nameList.item(0).getTextContent());
            }
        }

        return result;
    }
    public List<String> getCredits(String xmlPath) throws ParserConfigurationException, IOException, SAXException {

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc = db.parse(new File(xmlPath));
        doc.getDocumentElement().normalize();

        List<String> result = new ArrayList<>();

        NodeList subjectNode = doc.getElementsByTagName("Subject");
        int count = subjectNode.getLength();

        for (int i = 0; i < subjectNode.getLength(); i++) {
            Node subjectNodes = subjectNode.item(i);

            if (subjectNodes.getNodeType() == Node.ELEMENT_NODE) {
                Element firstSubjectElement = (Element)subjectNodes;

                NodeList nameList = firstSubjectElement.getElementsByTagName("credit");
                result.add(nameList.item(0).getTextContent());
            }
        }

        return result;
    }

}
