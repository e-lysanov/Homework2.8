package ru.elysanov.homework2_82;

import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DepServiceImpl implements DepService {

    private final EmployeeService employeeService;

    public DepServiceImpl(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public String findMinimalSalaryWorkerOfDepartment(int department) {

        final Optional<Employee> employee = employeeService.getAllEmployees().stream()
                .filter(e -> e.getDepartment() == department)
                .min(Comparator.comparingInt(e -> e.getSalary()));

        return "Сотрудник с наименьшей зарплатой в " + department + " отделе: " + employee;
    }
    //
    @Override
    public String findHighestSalaryWorkerOfDepartment(int department) {

        final Optional<Employee> employee = employeeService.getAllEmployees().stream()
                .filter(e -> e.getDepartment() == department)
                .max(Comparator.comparingInt(e -> e.getSalary()));

        return "Сотрудник с наибольшей зарплатой в " + department + " отделе: " + employee;
    }

    @Override
    public String printEmployeesOfDepartment(int department) {

        final List<Employee> employeesOfDepartment = employeeService.getAllEmployees().stream()
                .filter(e -> e.getDepartment() == department)
                .collect(Collectors.toList());
        return "Сотрудники " + department + " отдела: " + employeesOfDepartment;
    }

    @Override
    public Map<Integer, List<Employee>> printEmployeesByDepartments() {
        return employeeService.getAllEmployees().stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
    }
}
