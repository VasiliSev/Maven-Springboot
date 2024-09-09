package pro.sky.courseecmployeecontinuation.model;

import java.util.Objects;

public class Employee {

    private final String firstName;
    private final String lastName;
    private final int departmentID;
    private final int salary;

    public Employee(String firstName, String lastName, int departmentID, int salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.departmentID = departmentID;
        this.salary = salary;
    }

    public int getDepartmentID() {
        return departmentID;
    }

    public String getFirstName() {
        return firstName;
    }

    public int getSalary() {
        return salary;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFullName() {
        return (firstName + " " + lastName);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", departmentID=" + departmentID +
                ", salary=" + salary +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return departmentID == employee.departmentID && salary == employee.salary && Objects.equals(firstName, employee.firstName) && Objects.equals(lastName, employee.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, departmentID, salary);
    }
}





