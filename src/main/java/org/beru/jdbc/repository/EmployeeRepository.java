package org.beru.jdbc.repository;

import org.beru.jdbc.model.Employee;
import org.beru.jdbc.util.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository implements Repository<Employee>{

    private Connection getConnection(){
        return DatabaseConnection.getConnection();
    }
    @Override
    public List<Employee> findAll() {
        List<Employee> employeeList = new ArrayList<>();
        try(Connection connection = getConnection();
                Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM employee")
        ){
            while(rs.next()){
                employeeList.add(getEmploy(rs));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return employeeList;
    }


    @Override
    public Employee getById(Integer id) {
        Employee employee = new Employee();
        try(Connection connection = getConnection();
                PreparedStatement stmt = connection.prepareStatement("SELECT * FROM employee where id=?");
        ){
            stmt.setInt(1,id);
            ResultSet rs = stmt.executeQuery("SELECT * FROM employee where id=?");
            if(rs.next()){
                employee = getEmploy(rs);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return employee;
    }

    @Override
    public void save(Employee employee) {
        try(Connection connection = getConnection();
                PreparedStatement stmt = connection.prepareStatement("INSERT INTO employee (name,last_name,email,salary,curp) VALUES (?,?,?,?,?) ");
        ){
            setEmployee(employee, stmt);

            stmt.execute();

        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    @Override
    public void delete(Integer id) {
        try(Connection connection = getConnection();
                PreparedStatement stmt = connection.prepareStatement("DELETE FROM employee WHERE id=?")){
            stmt.setInt(1,id);
            stmt.execute();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    private static void setEmployee(Employee employee, PreparedStatement stmt) throws SQLException {
        stmt.setString(1, employee.getName());
        stmt.setString(2, employee.getLast_name());
        stmt.setString(3, employee.getEmail());
        stmt.setFloat(4, employee.getSalary());
        stmt.setString(5,employee.getCurp());
    }
    private static Employee getEmploy(ResultSet rs) throws SQLException {
        Employee e = new Employee();
        e.setId(rs.getInt("id"));
        e.setLast_name(rs.getString("last_name"));
        e.setEmail(rs.getString("email"));
        e.setSalary(rs.getFloat("salary"));
        e.setCurp(rs.getString("curp"));

        return e;
    }
}
