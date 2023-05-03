import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        University university = new University("My University");

        while (true) {
            System.out.println("1. Додати групу");
            System.out.println("2. Додати студента");
            System.out.println("3. Додати предмет до групи");
            System.out.println("4. Додати оцінку студенту по предмету");
            System.out.println("5. Вивести список студентів");
            System.out.println("6. Вивести кількість студентів в групі");
            System.out.println("7. Вивести кількість студентів в університеті");
            System.out.println("8. Додати предмет до студента");
            System.out.println("9. Вивести оцінки студента по предмету");
            System.out.println("10. Вивести оцінки групи по предмету");
            System.out.println("11. Вивести список студентів групи з сортуванням за ПІБ");
            System.out.println("12. Вивести список студентів групи з сортуванням за успішністю");
            System.out.println("13. Вивести список студентів групи з сортуванням за кількістю пропусків");
            System.out.println("14. Додати відвідувальність студента конкретного предмета");
            System.out.println("15. Вийти");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Введіть назву групи: ");
                    String groupName = scanner.next();
                    Group group = new Group(groupName);
                    university.addGroup(group);
                    break;
                case 2:
                    System.out.print("Введіть ім'я студента: ");
                    String name = scanner.next();
                    System.out.print("Введіть прізвище студента: ");
                    String surname = scanner.next();
                    Student student = new Student(name, surname);
                    university.addStudent(student);
                    break;
                case 3:
                    System.out.print("Введіть назву предмету: ");
                    String subjectName = scanner.next();
                    System.out.print("Введіть назву групи: ");
                    groupName = scanner.next();
                    group = university.getGroupByName(groupName);
                    Subject subject = new Subject(subjectName);
                    group.addSubject(subject);
                    break;
                case 4:
                    System.out.print("Введіть ім'я студента: ");
                    name = scanner.next();
                    System.out.print("Введіть прізвище студента: ");
                    surname = scanner.next();
                    student = university.getStudentByNameSurname(name, surname);
                    if (student == null) {
                        break;
                    }
                    System.out.print("Введіть назву предмету: ");
                    subjectName = scanner.next();
                    subject = university.getSubjectByName(subjectName);
                    if (subject == null) {
                        break;
                    }
                    System.out.print("Введіть оцінку: ");
                    int mark = scanner.nextInt();
                    student.addMark(subject, mark);
                    break;
                case 5:
                    List<Student> students = university.getStudents();
                    for (Student s : students) {
                        System.out.println(s.getName() + " " + s.getSurname());
                        List<Subject> subjects = s.getSubjects();
                        for (Subject sub : subjects) {
                            List<Integer> marks = s.getMarks(sub);
                            if (marks.size() == 0) {
                                continue;
                            }
                            double averageMark = marks.stream().mapToInt(Integer::intValue).average().getAsDouble();
                            System.out.printf("%s: %.2f\n", sub.getName(), averageMark);
                        }
                    }
                    break;
                case 6:
                    System.out.print("Введіть назву групи: ");
                    String groupName = scanner.next();
                    Group group = university.getGroupByName(groupName);
                    if (group == null) {
                        break;
                    }
                    int count = group.getStudents().size();
                    System.out.printf("К-сть студентів в групі %s: %d\n", groupName, count);
                    break;
                case 7:
                    count = university.getStudents().size();
                    System.out.printf("К-сть студентів в університеті: %d\n", count);
                    break;
                case 8:
                    System.out.print("Введіть ім'я студента: ");
                    String name = scanner.next();
                    System.out.print("Введіть прізвище студента: ");
                    String surname = scanner.next();
                    Student student = university.getStudentByNameSurname(name, surname);
                    if (student == null) {
                        break;
                    }
                    System.out.print("Введіть назву предмету: ");
                    String subjectName = scanner.next();
                    Subject subject = university.getSubjectByName(subjectName);
                    if (subject == null) {
                        break;
                    }
                    student.addSubject(subject);
                    break;
                case 9:
                    System.out.print("Введіть ім'я студента: ");
                    String name = scanner.next();
                    System.out.print("Введіть прізвище студента: ");
                    String surname = scanner.next();
                    student = university.getStudentByNameSurname(name, surname);
                    if (student == null) {
                        break;
                    }
                    System.out.print("Введіть назву предмету: ");
                    String subjectName = scanner.next();
                    subject = university.getSubjectByName(subjectName);
                    if (subject == null) {
                        break;
                    }
                    List<Integer> marks = student.getMarks(subject);
                    if (marks.size() == 0) {
                        break;
                    }
                    double averageMark = marks.stream().mapToInt(Integer::intValue).average().getAsDouble();
                    System.out.printf("%s %s: %.2f\n", name, surname, averageMark);
                    break;
                case 10:
                    System.out.print("Введіть назву групи: ");
                    groupName = scanner.next();
                    group = university.getGroupByName(groupName);
                    if (group == null) {
                        break;
                    }
                    System.out.print("Введіть назву предмету: ");
                    subjectName = scanner.next();
                    subject = university.getSubjectByName(subjectName);
                    if (subject == null) {
                        break;
                    }
                    students = group.getStudents();
                    for (Student s : students) {
                        marks = s.getMarks(subject);
                        if (marks.size() == 0) {
                            continue;
                        }
                        averageMark = marks.stream().mapToInt(Integer::intValue).average().getAsDouble();
                        System.out.printf("%s %s: %.2f\n", s.getName(), s.getSurname(), averageMark);
                    }
                    break;
                case 11:
                    groupName = scanner.next();
                    group = university.getGroupByName(groupName);
                    if (group == null) {
                        break;
                    }
                    students = group.getStudents();
                    Collections.sort(students, new StudentNameComparator());
                    for (Student s : students) {
                        System.out.printf("%s %s\n", s.getName(), s.getSurname());
                    }
                    break;
                case 12:
                    groupName = scanner.next();
                    group = university.getGroupByName(groupName);
                    if (group == null) {
                        break;
                    }
                    students = group.getStudents();
                    Collections.sort(students, new StudentAverageMarkComparator());
                    for (Student s : students) {
                        double averageMark = s.getAverageMark();
                        System.out.printf("%s %s: %.2f\n", s.getName(), s.getSurname(), averageMark);
                    }
                    break;
                case 13:
                    groupName = scanner.next();
                    group = university.getGroupByName(groupName);
                    if (group == null) {
                        break;
                    }
                    students = group.getStudents();
                    Collections.sort(students, new StudentAbsencesComparator());
                    for (Student s : students) {
                        int absences = s.getAbsences();
                        System.out.printf("%s %s: %d\n", s.getName(), s.getSurname(), absences);
                    }
                    break;
                case 14:
                    groupName = scanner.next();
                    group = university.getGroupByName(groupName);
                    if (group == null) {
                        break;
                    }
                    String studentName = scanner.next();
                    Student student = group.getStudentByName(studentName);
                    if (student == null) {
                        break;
                    }
                    subjectName = scanner.next();
                    subject = university.getSubjectByName(subjectName);
                    if (subject == null) {
                        break;
                    }
                    int visitsCount = scanner.nextInt();
                    student.addVisitsCount(subject, visitsCount);
                    break;
                case 15:
                    return;
                default:
                    break;
            }
        }
    }
}