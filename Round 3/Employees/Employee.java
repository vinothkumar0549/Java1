import java.util.List;
import java.util.ArrayList;

public class Employee {

    static List<Employee> emp = new ArrayList<>();
    int id;
    String name;
    int age;
    String desgnition;
    String department;
    String manager;

    Employee(int id, String name, int age, String desgnition, String department, String manager) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.desgnition = desgnition;
        this.department = department;
        this.manager = manager;
    }

    static void initializeEmployee(int id, String name, int age, String desgnition, String department, String manager) {
        emp.add(new Employee(id, name, age, desgnition, department, manager));
    }

    public static void PrintEmployee() {
        for (Employee e : emp) {
            System.out.println("ID: " + e.id + " Name: " + e.name + " Age: " + e.age + " Desgnition: " + e.desgnition
                    + " Department: " + e.department + " Manager: " + e.manager);
        }
    }

}
