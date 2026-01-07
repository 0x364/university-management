package university.management;

public class Enrollment {
    private Student student;
    private Course course;
    private double vize;   // vize
    private double fin;    // final
    private double grade;  // ortalama

    public Enrollment(Student student, Course course) {
        this.student = student;
        this.course = course;
        this.vize = -1; 
        this.fin = -1;
        this.grade = 0;
    }

    public Student getStudent() {
        return student;
    }

    public void setVize(double vize) {
        this.vize = vize;
        calculateGrade();
    }

    public void setFinal(double fin) {
        this.fin = fin;
        calculateGrade();
    }

    public double getGrade() {
        return grade;
    }

    private void calculateGrade() {
        if (vize >= 0 && fin >= 0) {
            this.grade = vize * 0.4 + fin * 0.6;
            student.setGpa(grade); 
        }
    }

	public Course getCourse() {
		return course;
	}
}