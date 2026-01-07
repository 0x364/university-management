package university.management;

import java.util.ArrayList;

public class Instructor {
	private String name;
	private ArrayList<Student> advisees; // onayladığı öğrencilerin listesi
	
	public Instructor(String name) {
		this.name = name;
		this.advisees = new ArrayList<>();
	}

	public String getName() {
		return name;
	}
	
    public void approveStudent(Student student) {
        if (!advisees.contains(student)) {
            advisees.add(student);
            System.out.println(name + " adlı danışman " + student.getName() + " öğrencisini onayladı.");
        }
    }

    public boolean isAdvisorOf(Student student) {
        return advisees.contains(student);
    }

	public ArrayList<Student> getAdvisees() {
		return advisees;
	}
    
}
