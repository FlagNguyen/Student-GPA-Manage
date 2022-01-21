
import Model.Student;
import Model.Subject;
import Model.Transcript;
import java.io.IOException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author asus
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {

        Management mn = new Management();
        Utility util = new Utility();

        Student[] students = new Student[100];
        Subject[] subjects = new Subject[100];
        Transcript[] transcripts = new Transcript[students.length];

        for (int i = 0; i < students.length; i++) {
            students[i] = new Student(0, " ", " ", " ", " ");
        }
        for (int i = 0; i < subjects.length; i++) {
            subjects[i] = new Subject(0, " ", 0, 0);
        }
        for (int i = 0; i < transcripts.length; i++) {
            Student student = new Student(0, " ", " ", " ", " ");

            Subject[] ses = new Subject[10];
            for (int j = 0; j < ses.length; j++) {
                ses[j] = new Subject(0, " ", 0, 0);
            }
            int[] q = new int[10];
            for (int j = 0; j < q.length; j++) {
                q[j] = 0;
            }
            transcripts[i] = new Transcript(student, ses, q);
        }
        
        //Test data:
        students[0] = new Student(10001, "IT", "Lam Ha Thu", "Ha Noi", "0436347323");
        students[1] = new Student(10002, "AI", "Ha Van An", "Ha Noi", "0749588123");
        students[2] = new Student(10003, "SE", "Tran Van Tuan", "Hung Yen", "0742388123");
        subjects[0] = new Subject(101, "Java Fundamental", 50, 2);
        subjects[1] = new Subject(102, "Java OOP", 30, 2);    
        
        
        while (true) {
            System.out.println("1.  Enter new student");
            System.out.println("2.  Enter new subject");
            System.out.println("3.  Register study");
            System.out.println("4.  Sort");
            System.out.println("5.  Print transcripts");
            System.out.println("6.  Exit");

            int choice = util.checkChoice("Enter your choice: ", 1, 6);

            switch (choice) {
                case 1:
                    for (int i = 0; i < students.length; i++) {
                        if (students[i].getStudent_id() == 0) {
                            if (i == 0) {
                                students[0] = mn.add_Student(students, 10000);
                                break;
                            } else {
                                students[i] = mn.add_Student(students, students[i - 1].getStudent_id());
                                break;
                            }
                        }
                    }
                    System.out.println("-------------------------------------------------------------");
                    util.print_StudentList(students);  
                    mn.output_file(students);
                    break;
                case 2:
                    for (int i = 0; i < subjects.length; i++) {
                        if (subjects[i].getSubject_id() == 0) {
                            if (i == 0) {
                                subjects[0] = mn.add_Subject(subjects, 100);
                                break;
                            } else {
                                subjects[i] = mn.add_Subject(subjects, subjects[i - 1].getSubject_id());
                                break;
                            }
                        }
                    }
                    System.out.println("-------------------------------------------------------------");
                    util.print_SubjectList(subjects);
                    mn.output_file(subjects);
                    break;
                case 3:
                    mn.register_Study(students, subjects, transcripts);
                    mn.output_file(transcripts);
                    break;
                case 4:
                    System.out.println("1. Sort by student's name");
                    System.out.println("2. Sort by subject's name");
                    int c = util.checkChoice("Enter your choice: ", 1, 2);
                    if (c == 1) {
                        mn.sort_by_name(transcripts);
                    } else {
                        mn.sort_by_subject(transcripts);
                    }
                    break;
                case 5:
                    util.print_Transcript(transcripts);
                    break;
                case 6:
                    return;
            }

        }

    }

}
