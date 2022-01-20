
import Model.Student;
import Model.Subject;
import Model.Transcript;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author asus
 */
public class Utility {

    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    public int checkChoice(String mess, int a, int b) {
        int output = 0;
        try {
            do {
                System.out.print(mess);
                output = Integer.parseInt(in.readLine());
                if (output >= a && output <= b) {
                    break;
                }
                System.err.printf("\nPlease enter %d-%d !!", a, b);

            } while (true);
        } catch (Exception e) {
            System.err.println("Please enter integer !!!");
        }
        return output;
    }

    public String checkString(String mess) throws IOException {
        String out = "";
        try {
            do {
                System.out.print(mess);
                out = in.readLine();
                if (out.isEmpty()) {
                    System.err.println("Please Enter String");
                } else {
                    break;
                }
            } while (true);
        } catch (Exception e) {
        }

        return out.trim();
    }

    public int checkInterger(String mess) {
        int output = 0;
        do {
            try {
                System.out.print(mess);
                output = Integer.parseInt(in.readLine());
                break;
            } catch (Exception e) {
                System.err.println("Please Enter Interger");
            }

        } while (true);

        return output;
    }

    protected String standardlizeString(String s) {
        String strOut = "";
        String st = "";
        st = s.trim().toLowerCase().replaceAll("\\s+", " ");

        String[] temp = new String[100];
        temp = st.split(" ");
        for (int i = 0; i <= temp.length - 1; i++) {
            strOut += String.valueOf(temp[i].charAt(0)).toUpperCase() + temp[i].substring(1);
            if (i < temp.length - 1) {
                strOut += " ";
            }
        }
        return strOut;
    }

    protected void print_Student(Student student) {
        System.out.printf("%-5d| %-15s| %-10s| %-12s| %-5s|\n", student.getStudent_id(), student.getName(), student.getAddress(),
                student.getPhone(), student.getClass_name());
    }

    protected void print_StudentList(Student[] students) {
        System.out.printf("%-5s| %-15s| %-10s| %-12s| %-5s|\n", "ID", "Student Name", "Address", "Contact", "Class");
        for (Student student : students) {
            if (student.getStudent_id() != 0) {
                print_Student(student);
            }
        }
        System.out.println();
    }

    protected void print_SubjectList(Subject[] subjects) {
        System.out.printf("%-5s| %-20s| %-10s| %-15s|\n", "ID", "Subject Name", "Credit", "Type");
        for (Subject subject : subjects) {
            if (subject.getSubject_id() != 0) {
                System.out.println(subject.toString());
            }
        }
    }

    protected void print_Transcript(Transcript[] transcripts) {
        for (Transcript transcript : transcripts) {
            if (transcript.getStudent().getStudent_id() != 0) {
                System.out.printf("Student information: \n");
                print_Student(transcript.getStudent());
                System.out.println("Transcript: ");
                for (int j = 0; j < transcript.getSubjects().length; j++) {
                    if (transcript.getSubjects()[j].getSubject_id() != 0) {
                        System.out.printf("%-20s| %-10d| %-5d|\n", transcript.getSubjects()[j].getSubject_name(), transcript.getSubjects()[j].getCredit(), transcript.getMarks()[j]);
                    }
                }
                System.out.println("-------------------------------------------------");
            }
        }
    }

    protected Student find_Student(Student[] students) {
        do {
            int id = checkInterger("Enter student's id: ");
            for (Student student : students) {
                if (id == student.getStudent_id()) {
                    return student;
                }
            }
            System.err.println("Your id doesn't exist in student list !");
        } while (true);
    }

    protected Subject find_Subject(Subject[] subjects) {
        do {
            int id = checkInterger("Enter subject's id: ");
            for (Subject subject : subjects) {
                if (id == subject.getSubject_id()) {
                    return subject;
                }
            }
            System.err.println("This subject doesn't exist in subject list !");
        } while (true);
    }

    protected boolean find_Student(Transcript[] transcript, Student stu) {
        for (Transcript transcript1 : transcript) {
            if (transcript1.getStudent().equals(stu)) {
                return true; //Existed student
            }
        }
        return false;
    }

    protected boolean find_Subject(Subject[] subjects, Subject sub) {
        for (int i = 0; i < subjects.length; i++) {
            if (subjects[i].equals(sub)) {
                return true;
            }
        }
        return false;
    }

}
