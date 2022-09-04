package com.example.controller.employee;

import com.example.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.repository.EmployeeRepository;

import java.util.List;
import java.util.Optional;

@Controller
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping({"/","list"})
    public String showEmployees(Model model){
        List<Employee> employeeList = employeeRepository.findAll();
        model.addAttribute("employees",employeeList);
        return "employees";
    }

    @GetMapping("/addEmployeeForm")
    public String addEmployeeForm(Model model){
        Employee employee=new Employee();
        model.addAttribute("employee",employee);
        return "addEmployee";
    }

    @PostMapping("/addEmployee")
    public String saveEmployee(@ModelAttribute Employee employee){
        try {
            employeeRepository.save(employee);
        }catch (Exception e){
            e.printStackTrace();
        }
        return "redirect:/";
    }
    @GetMapping("/getEmployeeById")
    public String getEmployee(@RequestParam Long id,Model model){
        Employee employee=employeeRepository.findById(id).get();
        model.addAttribute("employee",employee);
        return "addemployee";
    }

    @GetMapping("/deleteEmployeeById")
    public String deleteEmployeeById(@RequestParam Long id) {
        try {
            employeeRepository.deleteById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/";
    }

}
