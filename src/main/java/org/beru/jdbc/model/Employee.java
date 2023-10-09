package org.beru.jdbc.model;

public class Employee {
    private Integer id;
    private String name;
    private String last_name;
    private String email;
    private Float salary;
    private String curp;
    public Employee() {
    }
    public Employee(Integer id, String name, String last_name, String email, Float salary, String curp) {
        this.id = id;
        this.name = name;
        this.last_name = last_name;
        this.email = email;
        this.salary = salary;
        this.curp = curp;
    }

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Float getSalary() {
        return salary;
    }

    public void setSalary(Float salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", email='" + email + '\'' +
                ", salary=" + salary + '\'' +
                ", curp=" + curp +
                '}';
    }
}
