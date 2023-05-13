package ru.elysanov.homework2_82;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(path = "/departments")
@RestController
public class ControllerDep {

    private final DepService depService;
    public ControllerDep(DepService depService) { this.depService = depService; }

    @GetMapping(path = "/max-salary")
    public String findHighestSalaryWorkerOfDepartment(@RequestParam("departmentId") int department) { return depService.findHighestSalaryWorkerOfDepartment(department);}

    @GetMapping(path = "/min-salary")
    public String findMinimalSalaryWorkerOfDepartment(@RequestParam("departmentId") int department) { return depService.findMinimalSalaryWorkerOfDepartment(department);}

    @GetMapping(path = "/all")
    String printEmployeesOfDepartment(@RequestParam("departmentId") int department) { return depService.printEmployeesOfDepartment(department);}

    @GetMapping(path = "/all-byDepartments")
    public String printEmployeesByDepartments() { return depService.printEmployeesByDepartments().toString(); }

}
