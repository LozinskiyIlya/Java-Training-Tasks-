package com.jwt.dao;

import com.jwt.model.Employee;

import java.util.List;

public interface EmployeeDAO {

    void addEmployee(Employee employee);

    List<Employee> getAllEmployees();

    void deleteEmployee(Integer employeeId);

    Employee getEmployee(int employeeId);

    Employee updateEmployee(Employee employee);
}
