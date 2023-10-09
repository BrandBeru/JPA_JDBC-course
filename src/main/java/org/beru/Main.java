package org.beru;

import jakarta.persistence.EntityManager;
import org.beru.jdbc.model.Employee;
import org.beru.jdbc.repository.EmployeeRepository;
import org.beru.jdbc.repository.Repository;
import org.beru.jdbc.util.DatabaseConnection;
import org.beru.jpa.Util.UtilEntity;

import java.sql.*;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {
        EntityManager entityManager = UtilEntity.getEntityManager();

        entityManager.exe

        List<Employee> employees = entityManager.createQuery("SELECT e FROM Employee e ", Employee.class).getResultList();
        System.out.println("LIST");
        employees.forEach(System.out::println);
    }
    private void jpa(){
        try(
                Connection con = DatabaseConnection.getConnection();
        ){
            if(con.getAutoCommit())
                con.setAutoCommit(false);
            try{
                Repository<Employee> repository = new EmployeeRepository();
                //repository.save(new Employee(0,"Juan","Bernal","juan@gmail.com",3000F, "FTPDS"));
                repository.findAll().forEach(System.out::println);

                con.commit();
            }catch (SQLException e){
                con.rollback();
                e.printStackTrace();
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}