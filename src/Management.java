
import Model.Student;
import Model.Subject;
import Model.Transcript;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author asus
 */
public class Management {

    Utility util = new Utility();

    protected Student add_Student(Student[] students, int i) throws IOException {
        int id = i + 1;
        String name = util.standardlizeString(util.checkString("Enter your name: "));
        String address = util.standardlizeString(util.checkString("Enter your city: "));
        String phone = "";
        do {
            phone = util.checkString("Enter your phone number: ");
            if (phone.matches("[0-9]+")) {
                if (phone.length() >= 5 && phone.length() <= 10) {
                    break;
                } else {
                    System.err.println("Your number's length must be between 5-10");
                }
            } else {
                System.err.println("Your number cant contain a character !");
            }

        } while (true);

        String class_name = util.checkString("Enter your class: ");

        Student s = new Student(id, class_name, name, address, phone);
        return s;
    }

    protected Subject add_Subject(Subject[] subjects, int i) throws IOException {
        int id = i + 1;
        String name = util.standardlizeString(util.checkString("Enter subject's name: "));
        int credit = util.checkInterger("Enter total credit: ");
        System.out.println("1.  General");
        System.out.println("2.  Fundamental");
        System.out.println("3.  Specialized");
        int type = util.checkChoice("Enter subject's type: ", 1, 3);

        Subject s = new Subject(id, name, credit, type);
        return s;
    }

    protected void register_Study(Student[] students, Subject[] subjects, Transcript[] transcripts) {
        System.out.println("");
        Student stu = util.find_Student(students);
        System.out.println("Student's Info: ");
        util.print_Student(stu);
        int pos = 0;
        if (util.find_Student(transcripts, stu)) {
            for (int i = 0; i < transcripts.length; i++) {
                if (transcripts[i].getStudent().equals(stu)) {
                    pos = i;
                    break;
                }
            }
        } else {
            for (int i = 0; i < transcripts.length; i++) {
                if (transcripts[i].getStudent().getStudent_id() == 0) {
                    pos = i;
                    break;
                }
            }
        }
        transcripts[pos].setStudent(stu);
        Subject sub = util.find_Subject(subjects);
        System.out.println(sub.toString());

        if (util.find_Subject(transcripts[pos].getSubjects(), sub)) {
            for (int i = 0; i < transcripts[pos].getSubjects().length; i++) {
                if (transcripts[pos].getSubjects()[i].getSubject_id() == sub.getSubject_id()) {
                    System.out.println("Old Mark: " + transcripts[pos].getMarks()[i]);
                    int mark = util.checkChoice("Enter mark you want to change: ", 0, 10);
                    transcripts[pos].getMarks()[i] = mark;
                    break;
                }
            }
        } else {
            for (int i = 0; i < transcripts[pos].getSubjects().length; i++) {
                if (transcripts[pos].getSubjects()[i].getSubject_id() == 0) {
                    transcripts[pos].getSubjects()[i] = sub;
                    int mark = util.checkChoice("Enter mark of this subject: ", 0, 10);
                    transcripts[pos].getMarks()[i] = mark;
                    break;
                }
            }
        }
        System.out.println();
    }

    protected void sort_by_name(Transcript[] transcripts) {
        for (int i = 0; i < transcripts.length - 1; i++) {
            for (int j = i + 1; j < transcripts.length; j++) {
                if (transcripts[i].getStudent().getName().compareTo(transcripts[j].getStudent().getName()) > 0) {
                    Transcript temp = transcripts[i];
                    transcripts[i] = transcripts[j];
                    transcripts[j] = temp;
                }
            }
        }
    }

    protected void sort_by_subject(Transcript[] transcripts) {
        for (int i = 0; i < transcripts.length; i++) {
            if (transcripts[i].getStudent().getStudent_id() != 0) {
                for (int a = 0; a < transcripts[i].getSubjects().length - 1; a++) {
                    for (int b = 0; b < transcripts[i].getSubjects().length; b++) {
                        if (transcripts[i].getSubjects()[a].getSubject_name().compareTo(transcripts[i].getSubjects()[b].getSubject_name()) > 0) {
                            Subject temp = transcripts[i].getSubjects()[a];
                            transcripts[i].getSubjects()[a] = transcripts[i].getSubjects()[b];
                            transcripts[i].getSubjects()[b] = temp;
                        }
                    }
                }

            }
        }
    }
    
    static void writeFileStudent(Student[] students){
        try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("StudentFile.txt",true))){
            output.writeObject(students);
        } catch (IOException e) {
            System.err.println("Error when writing!");
        }
    }
    
    static void writeFileStudent(Subject[] ses){
        try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("SubjectFile.txt",true))){
            output.writeObject(ses);
        } catch (IOException e) {
            System.err.println("Error when writing!");
        }
    }
    
    static void writeFileStudent(Transcript trans){
        try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("TranscriptsFile.txt",true))){
            output.writeObject(trans);
        } catch (IOException e) {
            System.err.println("Error when writing!");
        }
    }
 
}
