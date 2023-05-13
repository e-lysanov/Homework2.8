package ru.elysanov.homework2_82;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeeService {

    String addEmployee(String firstName, String lastName, int department, int salary);

    String removeEmployee(String firstName, String lastName, int department, int salary);
    String findEmployee(String firstName, String lastName, int department, int salary);

    String printAllEmployees();

    List<Employee> getAllEmployees();
}
