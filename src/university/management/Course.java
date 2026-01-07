package university.management;


import java.util.ArrayList;

public class Course {
	private String code;
	private String title;
	private Instructor instructor;
	private int capacity; 
	private ArrayList<Enrollment> enrollments; // kayıtlar
	private String semester; // dönem 
    private String day;      // çakışma kontrolü için gün
    private int startHour;   // ders başlangıç saati
    private int endHour;     // ders bitiş saati

    public Course(String code, String title, Instructor instructor, int capacity, String semester, String day, int startHour, int endHour) {
        this.code = code;
        this.title = title;
        this.instructor = instructor;
        this.capacity = capacity;
        this.semester = semester;
        this.day = day;
        this.startHour = startHour;
        this.endHour = endHour;
        this.enrollments = new ArrayList<>();
    }

    //  öğrenci ekleme eklerken şartlar
    public boolean addStudent(Student student) {

        // danışman onayı yoksa 
        if (student.getAdvisor() == null || !student.getAdvisor().isAdvisorOf(student)) {
            System.out.println("Kayıt başarısız! " + student.getName() + " için danışman onayı gerekli.");
            return false;
        }
        // zaten kayıtlıysa
        for (Enrollment e : enrollments) {
            if (e.getStudent().getId().equals(student.getId())) {
                System.out.println("Kayıt başarısız! Öğrenci zaten bu dersi almış: " + code);
                return false;
            }
        }
        // kota dolu
        if (enrollments.size() >= capacity) {
            System.out.println("Kayıt başarısız! Ders dolu: " + code);
            return false;
        }
        //  ÇAKIŞMA (DÜZELTİLDİ)
        // öğrencinin kendi ders programını (getStudentEnrollments) kontrol ediyoruz.
        for (Enrollment e : student.getStudentEnrollments()) {
            Course takenCourse = e.getCourse();
            // aynı dönemmi
            if (takenCourse.getSemester().equals(this.semester)) {
                // aynı gün mü
                if (takenCourse.getDay().equals(this.day)) {
                    // saat aralığı 
                    // (YeniBaşlangıç < EskiBitiş) VE (EskiBaşlangıç < YeniBitiş)
                    if (this.startHour < takenCourse.getEndHour() && takenCourse.getStartHour() < this.endHour) {
                        System.out.println("Kayıt Başarısız! ÇAKIŞMA VAR: " + student.getName() + " için " + 
                                           this.code + " (" + this.startHour + "-" + this.endHour + ") ile " + 
                                           takenCourse.getCode() + " (" + takenCourse.getStartHour() + "-" + takenCourse.getEndHour() + ") çakışıyor.");
                        return false;
                    }
                }
            }
        }
     //  kayıt İşlemi . burada ders programlarına ekliyoruz sonraki işlemlerde kontrol için
        Enrollment newEnrollment = new Enrollment(student, this);
        //  dersin listesine ekle
        this.enrollments.add(newEnrollment);
        //  öğrencinin kendi ders programına ekle 
        student.addEnrollment(newEnrollment);
        System.out.println(student.getName() + " -> " + code + " dersine başarıyla eklendi.");
        return true;
        }

    // rapor
    public void printGradeDistribution() {
        int a = 0, b = 0, c = 0, d = 0, f = 0;
        for (Enrollment e : enrollments) {
            double g = e.getGrade();
            if (g >= 90) a++;
            else if (g >= 80) b++;
            else if (g >= 70) c++;
            else if (g >= 60) d++;
            else f++;
        }
        System.out.print("Ders: " + code + " (" + title + ") Not Dağılımı: ");
        System.out.println("A:" + a + "  B:" + b + "  C:" + c + "  D:" + d + "  F:" + f);
    }

    public ArrayList<Enrollment> getEnrollments() {
        return enrollments;
    }

    //  tüm ders kayıtları 
    private ArrayList<Enrollment> getAllEnrollments() {
        return enrollments;
    }

  
    public String getTitle() {
    	return title;
    }
    public String getCode() {
    	return code; 
    	}
    public String getSemester() {
    	return semester; 
    }
    public String getDay() {
    	return day;
    }
    public int getStartHour() { 
    	return startHour;
    }
    public int getEndHour() { 
    	return endHour; 
    }
}
