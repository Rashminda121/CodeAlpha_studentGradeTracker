import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Student {
    String name;
    List<Integer> grades;

    public Student(String name) {
        this.name = name;
        this.grades = new ArrayList<>();
    }

    public void addGrade(int grade) {
        grades.add(grade);
    }

    public double getAverage() {
        int sum = 0;
        for (int grade : grades) {
            sum += grade;
        }
        return (double) sum / grades.size();
    }

    public int getHighest() {
        return grades.stream().mapToInt(Integer::intValue).max().getAsInt();
    }

    public int getLowest() {
        return grades.stream().mapToInt(Integer::intValue).min().getAsInt();
    }
}

class Teacher {
    List<Student> students;

    public Teacher() {
        this.students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void printStatistics() {
        for (Student student : students) {
            System.out.println("Name: " + student.name);
            System.out.println("Average: " + student.getAverage());
            System.out.println("Highest: " + student.getHighest());
            System.out.println("Lowest: " + student.getLowest());
            System.out.println();
        }
    }
}

public class Main{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Teacher teacher = new Teacher();
        
        

        System.out.println("Enter student Name: ");
        String name = input.next();

        if (name != null) {
            Student student = new Student(name); // Create a Student object with the provided name
            
            // Get marks for three subjects
            System.out.println("Enter marks for Subject 1: ");
            int mark1 = input.nextInt();
            student.addGrade(mark1);
            
            System.out.println("Enter marks for Subject 2: ");
            int mark2 = input.nextInt();
            student.addGrade(mark2);
            
            System.out.println("Enter marks for Subject 3: ");
            int mark3 = input.nextInt();
            student.addGrade(mark3);
            
            teacher.addStudent(student); // Add the student to the teacher's list
        }

        teacher.printStatistics();
    }
}
