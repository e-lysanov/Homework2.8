package ru.elysanov.homework2_82;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import ru.elysanov.homework2_82.exceptions.EmployeeAlreadyAddedException;
import ru.elysanov.homework2_82.exceptions.EmployeeNotFoundException;
import ru.elysanov.homework2_82.exceptions.EmployeeStorageIsFullException;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    List<Employee> Employees = new ArrayList<>();


    @Override
    public String addEmployee(String firstName, String lastName, int department, int salary) {
        Employee employee = new Employee(firstName, lastName, department, salary);
        if (Employees.size() > 5) {
            throw new EmployeeStorageIsFullException("Employee storage is full");
        } else if (Employees.contains(String.valueOf(employee))) {
            throw new EmployeeAlreadyAddedException("Employee is already added");
        } else {
            Employees.add(employee);
        }
        return employee.toString();
    }

    @Override
    public String removeEmployee(String firstName, String lastName, int department, int salary) {
        Employee employee = new Employee(firstName, lastName, department, salary);
        if (Employees.contains(String.valueOf(employee))) {
            return "Employee removed";
        } else {
            throw new EmployeeNotFoundException("Employee don^t finded");
        }
    }

    @Override
    public String findEmployee(String firstName, String lastName, int department, int salary) {
        Employee employee = new Employee(firstName, lastName, department, salary);
        if (Employees.contains(String.valueOf(employee))) {
            return "Employee finded";
        } else {
            throw new EmployeeNotFoundException("Employee don^t finded");
        }
    }

    @Override
    public String printAllEmployees() {
        System.out.println(Employees.toString());
        return "Сотрудники всех отделов: " + Employees;
    }


    //    реализовал метод по поиску самого низкооплачиваемого сотрудника в отделе
    @Override
    public String findMinimalSalaryWorkerOfDepartment(int department) {

        final Optional<Employee> employee = Employees.stream()
                .filter(e -> e.getDepartment() == department)
                .min(Comparator.comparingInt(e -> e.getSalary()));

        return "Сотрудник с наименьшей зарплатой в " + department + " отделе: " + employee;
    }
//
//        реализовал метод по поиску самого высокооплачиваемого сотрудника в отделе
    @Override
    public String findHighestSalaryWorkerOfDepartment(int department) {

        final Optional<Employee> employee = Employees.stream()
                .filter(e -> e.getDepartment() == department)
                .max(Comparator.comparingInt(e -> e.getSalary()));

        return "Сотрудник с наибольшей зарплатой в " + department + " отделе: " + employee;
    }

    @Override
    public String printEmployeesOfDepartment(int department) {

        final List<Employee> employeesOfDepartment = Employees.stream()
                .filter(e -> e.getDepartment() == department)
                .collect(Collectors.toList());
        return "Сотрудники " + department + " отдела: " + employeesOfDepartment;
    }


    @Override
    public String printEmployeesOfAllDepartments() {
        return "Сотрудники всех отделов: " + Employees;
    }

}
