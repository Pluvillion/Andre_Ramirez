public class Employee {

    private String name;
    protected double salary;
    private int age;

    public Employee(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;

    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public double getSalary() {
        return this.salary;
    }

    public void raiseSalary() {
        this.salary = this.salary * 1.2;
    }

    public static void main (String[] args) {
        Employee emp = new Employee("Pulchra Fellini", 25, 50000);

        System.out.println("Name: " + emp.getName());
        System.out.println("Age: " + emp.getAge());
        System.out.println("Salary: " + emp.getSalary());

        emp.raiseSalary();

        System.out.println("New Salary after raise: " + emp.getSalary());
    }
}
