package e;

import java.util.Collection;

public class Employee {
    private int id;
    private String name;
    private int salary;
    private Collection<Certificate> certificates;

    public Employee() {
    }

    public Employee(int id) {
        this.id = id;
    }

    public Employee(String name, int salary,
                                  Collection<Certificate> certificates) {
        this.name = name;
        this.salary = salary;
        this.certificates = certificates;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Collection<Certificate> getCertificates() {
        return this.certificates;
    }

    public void setCertificates(Collection<Certificate> certificates) {
        this.certificates = certificates;
    }
}
