package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import repository.EmployeeRepository;

@Controller
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping({"/showEmployees","/","list"})
    @ModelAttribute
    public String showEmployees(Model model){
        model.addAttribute("employees",employeeRepository.findAll());
        return "employees";
    }
}
