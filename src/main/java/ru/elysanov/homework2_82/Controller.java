package ru.elysanov.homework2_82;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ru.elysanov.homework2_82.exceptions.EmployeeAlreadyAddedException;
import ru.elysanov.homework2_82.exceptions.EmployeeNotFoundException;
import ru.elysanov.homework2_82.exceptions.EmployeeStorageIsFullException;

@RequestMapping(path = "/employee")
@RestController
public class Controller {
    private final EmployeeService employeeService;

    public Controller(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @GetMapping(path = "/add")
    public String addEmployee(@RequestParam("firstName") String firstName,
                              @RequestParam("lastName")  String lastName,
                              @RequestParam("department") int department,
                              @RequestParam("salary") int salary) {
        try {
            return employeeService.addEmployee(firstName, lastName, department, salary);
        } catch (EmployeeStorageIsFullException exception) {
            exception.printStackTrace();
            return "Employee storage is full";
        } catch (EmployeeAlreadyAddedException exception) {
            exception.printStackTrace();
            return "Employee is already added";
        }
    }


    @GetMapping(path = "/remove")
    public String removeEmployee(@RequestParam("firstName") String firstName,
                                 @RequestParam("lastName")  String lastName,
                                 @RequestParam("department") int department,
                                 @RequestParam("salary") int salary) {
        try {
            return employeeService.removeEmployee(firstName, lastName, department, salary);
        } catch (EmployeeNotFoundException exception) {
            exception.printStackTrace();
            return "Employee don^t finded";
        }
    }


    @GetMapping(path = "/find")
    public String findEmployee(@RequestParam("firstName") String firstName,
                               @RequestParam("lastName")  String lastName,
                               @RequestParam("department") int department,
                               @RequestParam("salary") int salary) {
        try {
            return employeeService.findEmployee(firstName, lastName, department, salary);
        } catch (EmployeeNotFoundException exception) {
            exception.printStackTrace();
            return "Employee don^t finded";
        }
    }

    @GetMapping(path = "/print-all")
    public String printAllEmployees() { return employeeService.printAllEmployees(); }
}
