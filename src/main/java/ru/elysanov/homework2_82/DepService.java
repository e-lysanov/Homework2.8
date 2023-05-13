package ru.elysanov.homework2_82;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface DepService {
    String findMinimalSalaryWorkerOfDepartment(int department);

    String findHighestSalaryWorkerOfDepartment(int department);

    String printEmployeesOfDepartment(int department);

    Map<Integer, List<Employee>> printEmployeesByDepartments();
}
