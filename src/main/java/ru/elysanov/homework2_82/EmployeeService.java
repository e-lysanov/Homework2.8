package ru.elysanov.homework2_82;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public interface EmployeeService {

    String addEmployee(String firstName, String lastName, int department, int salary);

    String removeEmployee(String firstName, String lastName, int department, int salary);
    String findEmployee(String firstName, String lastName, int department, int salary);

    String printAllEmployees();
    String findHighestSalaryWorkerOfDepartment(int department);
    String findMinimalSalaryWorkerOfDepartment(int department);

    String printEmployeesOfDepartment(int department);

    String printEmployeesOfAllDepartments();
}
