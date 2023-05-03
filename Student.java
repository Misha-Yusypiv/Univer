import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

public class Student {
    private static int idCounter = 0;
    private int id;
    private String name;
    private String surname;
    private String patronymic;
    private String group;
    private List<String> subjects = new ArrayList<>();
    private Map<String, List<Integer>> marks = new HashMap<>();

    public Student(String name, String surname, String patronymic, String group) {
        this.id = ++idCounter;
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.group = group;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public List<String> getSubjects() {
        return subjects;
    }

    public void addSubject(String subject) {
        subjects.add(subject);
        marks.put(subject, new ArrayList<>());
    }

    public void removeSubject(String subject) {
        subjects.remove(subject);
        marks.remove(subject);
    }

    public Map<String, List<Integer>> getMarks() {
        return marks;
    }
}
