// Base Class 2: Electric Boogaloo (OOP and TestVehicle.java files for reference)

class Person {
    private String name;
    private int id;

    public Person(String name, int id) {
        this.name = name;
        this.id = id;
    }
    public String getName() {
        return name;
    }
    
    public int getId() {
        return id;
    }

    public void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
    }
}

//1st Subclass: Student
class Student extends Person {
    private String gradeLevel;

    public Student(String name, int id, String gradeLevel) {
        super(name, id);
        this.gradeLevel = gradeLevel;
    }

    public void displayInfo() {
        super.displayInfo();
        System.out.println("Grade Level: " + gradeLevel);
    }
}

//2nd Subclass: Teacher
class Teacher extends Person {
    private String subject;

    public Teacher(String name, int id, String subject) {
        super(name, id);
        this.subject = subject;
    }

    public void displayInfo() {
        super.displayInfo();
        System.out.println("Subject: " + subject);
    }
}

//3rd Subclass: Staff
class Staff extends Person {
    private String department;

    public Staff(String name, int id, String department) {
        super(name, id);
        this.department = department;
    }
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Department: " + department);
    }
}

// Main class to for Person, Student, Teacher, and Staff
public class Lab3 {
    public static void main(String[] args) {
        Person person = new Person("André Ramirez", 1);
        Student student = new Student("Frank Abegnale, Jr.", 2, "Freshman");
        Teacher teacher = new Teacher("Mr. Menesis", 3, "Object Oriented Programming");
        Staff staff = new Staff("Mr. Aramil", 4, "SACE / Information Technology");

        System.out.println("Person Info: ");
        person.displayInfo();
        System.out.println("Student Info: ");
        student.displayInfo();
        System.out.println("Teacher Info: ");
        teacher.displayInfo();
        System.out.println("Staff Info: ");
        staff.displayInfo();
    }
}

