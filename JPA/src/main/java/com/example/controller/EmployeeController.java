package com.example.controller;

import com.example.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.example.repository.EmployeeRepository;

import java.util.List;

@Controller
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;

 /*   @GetMapping({"/showEmployees","/","list"})
    public ModelAndView showEmployees(){
        ModelAndView model =new ModelAndView("employees");
        model.addObject("employeeList",employeeRepository.findAll());
        return model;
    }*/

    @GetMapping("/")
    public String showEmployees(Model model){
        List<Employee> employeeList = employeeRepository.findAll();
        model.addAttribute("employees",employeeList);
        return "employees";
    }
}
