package university.management;

public class Main {

	public static void main(String[] args) {
		
		 System.out.println("-- Üniversite Yönetim Sistemi --");

	        Instructor insAli = new Instructor("Dr.Ali");

	        
	        Student st1 = new Student("1", "Fatih");
	        Student st2 = new Student("2", "Sultan");
	        Student st3 = new Student("3", "Mehmet");
	        
	        st1.setAdvisor(insAli);
	        st2.setAdvisor(insAli); // öğrenciye danışman verme
	        st3.setAdvisor(insAli);

	        insAli.approveStudent(st1); // danışman onayı
	        insAli.approveStudent(st2);
	        
// ders kodu, ders adı, hocası,kontenjanı,dönemi,gün, başlangıc ve bitiş saatleri
	        Course cs101 = new Course("CS101", "Siber Güvenlik", insAli, 2, "2025-Bahar", "Pazartesi", 9, 11);
	        Course cs102 = new Course("CS102", "Ağ Güvenliği", insAli, 2, "2025-Bahar", "Pazartesi", 10, 12); // çakışır

	        cs101.addStudent(st1);
	        cs101.addStudent(st1); // tekrar kaydolamaz
	        cs101.addStudent(st2);
	        cs101.addStudent(st3); // danışman onayı yok / kapasite dolu

	        cs102.addStudent(st1); // çakışma

	        // not girişi
	        for (Enrollment e : cs101.getEnrollments()) {
	            if (e.getStudent().getName().equals("Fatih")) {
	                e.setVize(90);
	                e.setFinal(70);
	            }
	            if (e.getStudent().getName().equals("Sultan")) {
	                e.setVize(100);
	                e.setFinal(60);
	            }
	        }

	        // not raporu
	        cs101.printGradeDistribution();

	        // dönem  listeleme
	        System.out.println("\n--- 2025-Bahar Dönemi Dersleri ---");
	        System.out.println(cs101.getTitle() + " | " + cs101.getSemester());
	        System.out.println(cs102.getTitle() + " | " + cs102.getSemester());

	        // öğrenci gpa
	        System.out.println("\n--- Öğrenci GPA Listesi ---");
	        for (Enrollment e : cs101.getEnrollments()) {
	            Student stu = e.getStudent();
	            System.out.println(stu.getName() + " | " + e.getCourse().getTitle() + " | GPA: " + stu.getGpa());
	        }
	        // öğretmenin onayladığı öğrenciler
	         System.out.println("\n---Ali Hocanın ÖĞRENCİLERLİ---");
	        for(int i=0;i<insAli.getAdvisees().size();i++) {
	        	System.out.println(insAli.getAdvisees().get(i).getName());
	        }
		
	}

}
