package ru.elysanov.homework2_82;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import ru.elysanov.homework2_82.exceptions.BadRequestException;
import ru.elysanov.homework2_82.exceptions.EmployeeAlreadyAddedException;
import ru.elysanov.homework2_82.exceptions.EmployeeNotFoundException;
import ru.elysanov.homework2_82.exceptions.EmployeeStorageIsFullException;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    List<Employee> Employees = new ArrayList<>();


    @Override
    public String addEmployee(String firstName, String lastName, int department, int salary) {
        Employee employee = new Employee(firstName, lastName, department, salary);
        employee.setFirstName(StringUtils.capitalize(employee.getFirstName()));
        employee.setLastName(StringUtils.capitalize(employee.getLastName()));
        if (Employees.size() > 5) {
            throw new EmployeeStorageIsFullException("Employee storage is full");
        } else if (Employees.contains(String.valueOf(employee))) {
            throw new EmployeeAlreadyAddedException("Employee is already added");
        } else if (!StringUtils.isAlpha(employee.getFirstName())) {
            throw new BadRequestException();
        } else if (!StringUtils.isAlpha(employee.getLastName())) {
            throw new BadRequestException();
        } else {
            Employees.add(employee);
        }
        return employee.toString();
    }

    @Override
    public String removeEmployee(String firstName, String lastName, int department, int salary) {
        Employee employee = new Employee(firstName, lastName, department, salary);
        employee.setFirstName(StringUtils.capitalize(employee.getFirstName()));
        employee.setLastName(StringUtils.capitalize(employee.getLastName()));
        if (Employees.contains(String.valueOf(employee))) {
            return "Employee removed";
        } else if (!StringUtils.isAlpha(employee.getFirstName())) {
            throw new BadRequestException();
        } else if (!StringUtils.isAlpha(employee.getLastName())) {
            throw new BadRequestException();
        } else {
            throw new EmployeeNotFoundException("Employee don^t finded");
        }
    }

    @Override
    public String findEmployee(String firstName, String lastName, int department, int salary) {
        Employee employee = new Employee(firstName, lastName, department, salary);
        employee.setFirstName(StringUtils.capitalize(employee.getFirstName()));
        employee.setLastName(StringUtils.capitalize(employee.getLastName()));
        if (Employees.contains(String.valueOf(employee))) {
            return "Employee finded";
        } else if (!StringUtils.isAlpha(employee.getFirstName())) {
            throw new BadRequestException();
        } else if (!StringUtils.isAlpha(employee.getLastName())) {
            throw new BadRequestException();
        } else {
            throw new EmployeeNotFoundException("Employee don^t finded");
        }
    }

    @Override
    public String printAllEmployees() {
        System.out.println(Employees.toString());
        return "Все сотрудники: " + Employees;
    }

    @Override
    public List<Employee> getAllEmployees() { return Employees; }

}
