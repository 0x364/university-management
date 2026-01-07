package university.management;

import java.util.ArrayList;

public class Student {
    private String id;
    private String name;
    private double gpa; // genel not
    private Instructor advisor; // danışman
    private ArrayList<Enrollment> studentEnrollments;
    public Student(String id, String name) {
        this.id = id;
        this.name = name;
        this.gpa = 0.0;
        this.advisor = null;
        this.studentEnrollments = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }
 // --- danışman işlemleri ---
    public void setAdvisor(Instructor advisor) {
        this.advisor = advisor;
    }

    public Instructor getAdvisor() {
        return advisor;
    }
    //öğrencinin aldığı dersleri döndüren metod
    public ArrayList<Enrollment> getStudentEnrollments() {
        return studentEnrollments;
    }

    // öğrenciye ders kaydı ekleyen metod
    public void addEnrollment(Enrollment e) {
        studentEnrollments.add(e);
    }
}

